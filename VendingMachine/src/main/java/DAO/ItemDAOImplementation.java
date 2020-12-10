/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class ItemDAOImplementation implements ItemDAOInterface {

    List<Item> items = new ArrayList<>();
    public final String ITEM_RECORD;

    public ItemDAOImplementation() {

        ITEM_RECORD = "item_file.txt";
    }

    public ItemDAOImplementation(String ITEM_RECORD) {
        this.ITEM_RECORD = ITEM_RECORD;
    }

    @Override
    public List<Item> getAllItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getItem(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateItem(String id, Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadItems() {
        
        Scanner reader;
        
        try {
            
        }
        
        catch (Exception e)
        {
            
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
