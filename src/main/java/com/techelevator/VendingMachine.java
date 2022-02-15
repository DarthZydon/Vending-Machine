package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY hh:mm:ss a");
        LocalDateTime time = LocalDateTime.now();
        logWriter(String.format(String.format("%s FEED MONEY $%.2f $%.2f", time.format(formatter), (double) dollars, customerBalance / 100.0)));
        return customerBalance;
    }

    public int getCustomerBalance() {
        return customerBalance;
    }

    public Product selectProduct(String slotID) throws VendException, FileNotFoundException {

        Map<String, Product> map = inventory.getInventory();
        Product product = map.get(slotID);

        if (!inventory.getInventory().containsKey(slotID)) {
            //product does not exist
            throw new VendException("Product does not exist, select another");
        } else if (product.getCount() == 0) {
            //product is sold out
            throw new VendException("SOLD OUT");
        } else if (customerBalance < product.getPrice()) {
            //customer doesn't have enough money
            throw new VendException("You don't have enough money");
        }

        customerBalance -= product.getPrice();
        machineBalance += product.getPrice();
        product.reduceCount();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY hh:mm:ss a");
        LocalDateTime time = LocalDateTime.now();
        logWriter(String.format(String.format("%s %s %s $%.2f $%.2f", time.format(formatter), product.getName(), slotID, product.getPrice() / 100.0, customerBalance / 100.0)));
        return product;
    }

    public int finishTransaction() {
        //end transaction, return change
        int change = customerBalance;
        customerBalance = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY hh:mm:ss a");
        LocalDateTime time = LocalDateTime.now();
        logWriter(String.format(String.format("%s GIVE CHANGE: $%.2f $%.2f", time.format(formatter), change / 100.0, customerBalance / 100.0)));
        return change;
    }

    public void logWriter(String logEntry) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Log.txt", true)));
            out.println(logEntry);
            out.close();
        } catch (IOException e) {
        }
    }
}