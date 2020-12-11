/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    static final String DELIMITER = "::";

    public ItemDAOImplementation() {

        ITEM_RECORD = "item_file.txt";
        loadItems();
    }

    public ItemDAOImplementation(String ITEM_RECORD) {
        this.ITEM_RECORD = ITEM_RECORD;
    }

    @Override
    public List<Item> getAllItems() {
        
        return items;
    }

    @Override
    public Item getItem(int id) {
        
        
        Item requestedItem = new Item ();
        
        for (Item item: items)
        {
            if (item.getId() == id)
            {
                requestedItem =  item;
                break;
            }
        }
        return requestedItem;
    }

    @Override
    public void updateItem(int id, Item item) {
        
      
        
        for (Item dirtyItem: items )
        {
            if (dirtyItem.getId() == id)
            {
                dirtyItem.setName(item.getName());
                dirtyItem.setCost(item.getCost());
                dirtyItem.setStock(item.getStock());
                break;
            }
        }
        
        
    }

    @Override
    public void loadItems() {

        Scanner reader = null;

        try {
            reader = new Scanner(new BufferedReader(new FileReader(ITEM_RECORD)));
        } catch (FileNotFoundException e) {
            //TODO

        }

        String currentLine;
        Item currentItem;

        while (reader.hasNextLine()) {
            currentLine = reader.nextLine();
            if (currentLine.contains("id")) {
                continue;
            }

            currentItem = unmarshallItem(currentLine);
            items.add(currentItem);
        }

        reader.close();

    }

    @Override
    public void saveItems() {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileWriter(ITEM_RECORD));

        } catch (IOException e) {
            System.err.println("Items are not being saved");
        }
        for (Item item : items) {
            writer.println(marshallItem(item));
        }

        writer.close();

    }

    @Override
    public Item unmarshallItem(String itemString) {

        String[] rawItem = itemString.split(DELIMITER);
        Item incomingItem = new Item();
        incomingItem.setId(Integer.parseInt(rawItem[0]));
        incomingItem.setName(rawItem[1]);
        incomingItem.setCost(Double.parseDouble(rawItem[2]));
        incomingItem.setStock(Integer.parseInt(rawItem[3]));

        return incomingItem;

    }

    @Override
    public String marshallItem(Item item) {

        String marshalled = "";

        marshalled = item.getId() + DELIMITER + item.getName() + DELIMITER + item.getCost() + DELIMITER + item.getStock();

        return marshalled;
    }

    @Override
    public boolean inStock(int id, int quantity) {
        
        boolean inStock = false;
        
        for (Item item: items)
        {
            if ((item.getId()== id) & (item.getStock()>= quantity))
            {
                return true;
            }
        }
        
        return inStock;
    }

}
