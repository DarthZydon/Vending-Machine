package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    //renamed "inventoryMap" to inventory for easier understanding
    public static final String FILEPATH = "vendingmachine.csv";
    public Map<String, Product> inventory = new TreeMap<>();
    File userInputFile = new File(FILEPATH);

    //moved up here, renamed "getInventoryMap" to "getInventory"
    public Map<String, Product> getInventory() throws FileNotFoundException {
        return inventory;
    }

    public void load() throws FileNotFoundException {
        try (Scanner fileScanner = new Scanner(userInputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splits = line.split("\\|");

                //int money = (int) (Double.parseDouble(splits[2]) * 100);
                //Product newProduct = new Product(splits[1], money, splits[3], 5);

                //create and rename Product variables
                String slotID = splits[0];
                String productName = splits[1];
                int productPrice = (int) (Double.parseDouble(splits[2]) * 100);
                String productCategory = splits[3];
                int productQuantity = 5;

                //create Product with new Product variables
                Product product = new Product(productName, productPrice, productCategory, productQuantity);

                //updated params to new Product variables
                inventory.put(slotID, product);
            }
        }
    }
}

