/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAO.AuditDAOInterface;
import DAO.ItemDAOInterface;
import DTO.Audit;
import DTO.Item;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author chris
 */
public class ServiceLayerImplementation implements ServiceLayerInterface {

    ItemDAOInterface iDao;
    AuditDAOInterface aDao;

    public ServiceLayerImplementation() {
    }

    public ServiceLayerImplementation(ItemDAOInterface iDao) {
        this.iDao = iDao;
    }

    @Override
    public List<Item> getAllItems() {

        List<Item> items = iDao.getAllItems();

        for (Item item : items) {
            if (item.getStock() <= 0) {
                items.remove(item);
            }
        }

        return items;
    }

    @Override
    public Item getItem(int id) {

        return iDao.getItem(id);
    }

    @Override
    public void updateItem(int id, Item item) {

        iDao.updateItem(id, item);
    }

    @Override
    public int processTransaction(int id, int quantity, int availableFunds)
            throws NoItemInventoryException, InsufficientFundsException {

        int change = availableFunds;
        Item chosenItem = getItem(id);
        Audit transactionLog;
        String errorMessage = "";
        int auditID = aDao.getNextId();
        LocalDateTime auditTime = LocalDateTime.now();

        if (chosenItem.getStock() < quantity) {
            errorMessage = "Sorry we only have " + chosenItem.getStock() + " more of these in stock.";
            transactionLog = new Audit(auditID, auditTime, errorMessage);
            aDao.saveAudit(transactionLog);
            throw new NoItemInventoryException(errorMessage);
        }

        if ((int) (chosenItem.getCost() * quantity * 100) > availableFunds) {

            errorMessage = "Insufficient funds. You can only purchase "
                    + ((int) (availableFunds / chosenItem.getCost())) + "of these items.";
            transactionLog = new Audit(auditID, auditTime, errorMessage);
            aDao.saveAudit(transactionLog);
            throw new InsufficientFundsException(errorMessage);
        }

        change = (availableFunds - (int) (chosenItem.getCost() * quantity * 100));
        Item postTransac = new Item(chosenItem.getName(), chosenItem.getCost(), id, chosenItem.getStock() - quantity);
        updateItem(id, postTransac);
        transactionLog = new Audit(auditID, auditTime,
                ("Item purchased: " + chosenItem.getName() + " - Quantity: " + quantity));

        return change;
    }

}
