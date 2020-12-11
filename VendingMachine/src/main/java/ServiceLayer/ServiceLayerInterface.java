/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DTO.Item;
import java.util.List;

/**
 *
 * @author chris
 */
public interface ServiceLayerInterface {

    List<Item> getAllItems();
    //Return a list of all items in the inventory

    Item getItem(int id);
    //Returns the requested item by id

    void updateItem(int id, Item item);
    //Updates changes to an item experienced during the program, such as changes in stock.
    
    int processTransaction (int id, int quantity, int availableFunds) throws NoItemInventoryException, InsufficientFundsException;
    //Handles the logic and exceptions encountered during a single purchase.
    
 
    
    
}
