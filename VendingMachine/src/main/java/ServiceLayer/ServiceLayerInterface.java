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
    
    List <Item> getAllItems();
    //Return a list of all items in the inventory
    
    Item getItem (String id);
    //Returns the requested item by id
    
    void updateItem(String id, Item item);
}
