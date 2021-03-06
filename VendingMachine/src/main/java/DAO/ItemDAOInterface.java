/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;
import java.util.List;

/**
 *
 * @author chris
 */
public interface ItemDAOInterface {
    
    List <Item> getAllItems();
    //Return a list of all items in the inventory
    
    Item getItem (int id);
    //Returns the requested item by id
    
    void updateItem(int id, Item item);
    //Updates the given item's information
    
    boolean inStock (int id, int quantity);
    //Returns true if the given item is in stock.
    
    void loadItems();
    //Loads items stored in the data file.
    
    void saveItems();
    //Saves the current inventory into the data file.
    
    
    Item unmarshallItem(String itemString);
    //Unmarshall's the item string into the components of the Item Object.
    
    String marshallItem (Item item);
    //Returns a string of the Item data fields ready to be writtten into the file.
}
