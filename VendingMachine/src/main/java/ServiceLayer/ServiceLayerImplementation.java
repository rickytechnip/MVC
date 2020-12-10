/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAO.ItemDAOInterface;
import DTO.Change;
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
        
        
        List <Item> items = dao.getAllItems();
        
        for (Item item: items)
        {
            if (item.getStock() <= 0)
            {
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
     public Change calculateChange (double rawChange)
   {
       Change expectedChange = new Change (rawChange);
       
       int normalizedChange = (int) (rawChange * 100);
       
       expectedChange.setQuarters(normalizedChange/25);
       normalizedChange = normalizedChange % 25;
       
       expectedChange.setDimes(normalizedChange/10);
       normalizedChange = normalizedChange % 10;
       
       expectedChange.setNickels(normalizedChange/5);
       normalizedChange = normalizedChange % 5;
       
       expectedChange.setPennies(normalizedChange);
       
       return expectedChange;
   }
     
     
   @Override
   public String changeToString (Change change)
   {
       return change.toString();
   }
   
   
   public void processTransaction(int itemId, int itemAmount) throws NoItemInventoryException,InsufficientFundsException {}
    
}
