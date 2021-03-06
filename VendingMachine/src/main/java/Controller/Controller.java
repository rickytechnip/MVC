/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ServiceLayer.*;
import View.View;
import java.util.*;
import DTO.Item;


/**
 *
 * @author rickytechnip
 */
public class Controller {
    
    private ServiceLayerImplementation serviceLayer = new ServiceLayerImplementation();
    private View view;
    private Change change;
    
    private int customItemId;
    private String customItemName;
    private int customItemNumber;
    
    public Controller( View inputView){
        
        view = inputView;
        change = new Change();
    }
    
    public List<Item> getInventory(){
        return serviceLayer.getAllItems();
    }
    
    public boolean isAvailable(int itemId, int itemAmount){
        List<Item> currentInventory = serviceLayer.getAllItems();
        
        for(Item item: currentInventory){
            if(item.getId() == itemId)
                return item.getStock() >= itemAmount;
        }
        return false;
   }
    
    public void run(){
        do{
            List<Integer> changeList = null;
            List<Item> currentInventory = getInventory();
            if(currentInventory == null || currentInventory.size() == 0){
                view.showEmptyInventory();
                view.bye();
                break;
            }
               
            view.showItems(currentInventory);
            
            view.askMoney();
            int userCent = (int) Math.floor(getInputDouble() * 100);
            
            view.askItems();
            int itemId = getInputInt();
            Item userItem = serviceLayer.getItem(itemId);
            
            view.askNumber();
            int itemAmount = getInputInt();
            
            boolean transactionSuccessful;
            boolean restart;
            boolean wannaQuit;
            do{
                transactionSuccessful = false;
                restart = false;
                wannaQuit = false;
                
                try{
                    serviceLayer.processTransaction(itemId, itemAmount, userCent);
                    transactionSuccessful = true;
                }
                catch(InsufficientFundsException e){
                    view.insufficientMoney();
                    int shortage = (int)((itemAmount * userItem.getCost()) * 100) - userCent;
                    view.showInputMoney(userCent, shortage);
                    view.moreMoneyOrRestartOrQuit();
                    
                    int again = getInputInt();
                    if(again == 1){
                        view.askMoney();
                        userCent += (int) Math.floor(getInputDouble() * 100);
                        continue;
                    }
                    else if(again == 0) {
                        view.moneyReturned();
                        restart = true;
                        break;
                    }
                    else{
                        view.moneyReturned();
                        wannaQuit = true;
                        break;
                    }
                }
                catch(NoItemInventoryException e){
                    view.insufficientStock();
                    view.askAgain();
                    int again = getInputInt();
                    if(again == 1){
                        view.moneyReturned();
                        restart = true;
                        break;
                    }
                    else{
                        wannaQuit = true;
                        break;
                    }
                }
            }while(!transactionSuccessful);
            
            if(restart)
                continue;
            if(wannaQuit){
                view.bye();
                break;
            }
                
                        
            int cost = (int) Math.floor(calculatePrice(itemId, itemAmount) * 100);
            changeList = change.makeChange(userCent, cost);
            
            view.printOutCome(itemId, userItem.getName(), itemAmount, changeList);
            view.askAgain();
            int again = getInputInt();
            if(again == 1)
                continue;
            else{
                view.bye();
                break;
            }
                
        }while(true);
    }
    
    public double calculatePrice(int itemId, int itemAmount){
        Item currentItem = serviceLayer.getItem(itemId);
        return currentItem.getCost() * itemAmount;
    }
    
    public int getInputInt(){
        int userInputInt = 0;
        boolean inputSuccess;
        Scanner input = null;
        do{
            inputSuccess = false;
            try{
                input = new Scanner(System.in);
                userInputInt = input.nextInt();
                if(userInputInt < 0)
                    throw new InputMismatchException();
                inputSuccess = true;
            }
            catch(InputMismatchException e){
                view.errorNumber();
                continue;
            }
        }while(! inputSuccess);
        return userInputInt;
    }
    
    public double getInputDouble(){
        double userInputDouble = 0;
        boolean inputSuccess;
        Scanner input = null;
        do{
            inputSuccess = false;
            try{
                input = new Scanner(System.in);
                userInputDouble = input.nextDouble();
                if(userInputDouble < 0)
                    throw new InputMismatchException();
                inputSuccess = true;
            }
            catch(InputMismatchException e){
                view.errorNumber();
                continue;
            }
        }while(! inputSuccess);
        return userInputDouble;
    }
}
