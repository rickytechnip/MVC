/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAO.ItemDAOInterface;
import DTO.Item;
import java.util.List;

/**
 *
 * @author chris
 */
public class ServiceLayerImplementation implements ServiceLayerInterface {

    ItemDAOInterface dao;

    public ServiceLayerImplementation() {
    }

    public ServiceLayerImplementation(ItemDAOInterface dao) {
        this.dao = dao;
    }

    @Override
    public List<Item> getAllItems() {

        List<Item> items = dao.getAllItems();

        for (Item item : items) {
            if (item.getStock() <= 0) {
                items.remove(item);
            }
        }

        return items;
    }

    @Override
    public Item getItem(int id) {

        return dao.getItem(id);
    }

    @Override
    public void updateItem(int id, Item item) {

        dao.updateItem(id, item);
    }

    @Override
    public void buyItem(int id, double availableFunds) {
        
        
        try
        {
            if (!dao.inStock(id))
        {
            throw new NoItemInventoryException ();
 
        }
            
            if (dao.getItem(id).getCost() > availableFunds)
            {
                throw new InsufficientFundsException ();
            }
        }

        catch(NoItemInventoryException e)
                    {
                    
                    }
        
        catch (InsufficientFundsException e)
        {
            
        }
    }

    

}
