package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Map;

public class VendingMachine {

    private Inventory inventory = new Inventory();
    private int customerBalance = 0;
    private int machineBalance = 0;

    public Inventory getInventory() {
        return inventory;
    }

    public int feedMoney(int dollars) {
        customerBalance += dollars * 100;
        String logMessage = String.format("FEED MONEY: $%.2f $%.2f", (double) dollars, customerBalance / 100.0);
        return customerBalance;
    }

    public int getCustomerBalance() {
        return customerBalance;
    }

    public Product selectProduct(String slotID) throws VendExceptions, FileNotFoundException {

        if (!inventory.getInventory().containsKey(slotID)) {
            //product does not exist
            throw new VendExceptions("Product does not exist, select another");
        }

        Map<String, Product> map = inventory.getInventory();
        Product product = map.get(slotID);

        if (product.getCount() == 0) {
            //product is sold out
            throw new VendExceptions("SOLD OUT");
        }

        if (customerBalance < product.getPrice()) {
            //customer doesn't have enough money
            throw new VendExceptions("You don't have enough money");
        }

        customerBalance -= product.getPrice();
        machineBalance += product.getPrice();
        product.reduceCount();
        String logMessage = String.format("%s %s %.2f %.2f", product.getName(), slotID, product.getPrice(), customerBalance / 100.0);
        return product;
    }

    public int finishTransaction() {
        //end transaction, return change
        int change = customerBalance;
        customerBalance = 0;
        String logMessage = String.format("GIVE CHANGE: $%.2f $%.2f",  change/100.0, customerBalance/100.0);
        return change;
    }
}




//    private Inventory workingInventory;
//    private int customerBalance = 0;
//    private int machineBalance = 0;
//
//    public VendingMachine(String inventoryFilePath) {
//        this.workingInventory = new Inventory();
//    }
//
//    public Inventory getWorkingInventory() {
//        return workingInventory;
//    }
//
//    public int feedMoney(int moneyEntered) {
//        customerBalance += moneyEntered;
//        return customerBalance;
//    }
//
//    public Product selectProduct(String slotID) throws VendExceptions {
//        Product product = workingInventory.inventoryMap.get(slotID);
//        if (customerBalance < product.getPrice()) {
//            //customer doesn't have enough money
//            throw new VendExceptions("You don't have enough money");
//        }
//        if (product.getCount() < 1) {
//            //product is sold out
//            throw new VendExceptions("SOLD OUT");
//
//        }
//        customerBalance -= product.getPrice();
//        machineBalance += product.getPrice();
//        product.reduceCount();
//
//        return product;
//    }
//
//    public int finishTransaction() {
//        int change = customerBalance;
//        customerBalance = 0;
//        return change;
//    }
//
//
//
//}
