package com.techelevator;

import com.techelevator.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    public static final String FILEPATH = "vendingmachine.csv";
    public Map<String, Product> inventory = new TreeMap<>();
    File userInputFile = new File(FILEPATH);

    public Map<String, Product> getInventory() throws FileNotFoundException {
        return inventory;
    }

    public void load() throws FileNotFoundException {
        try (Scanner fileScanner = new Scanner(userInputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splits = line.split("\\|");

                String slotID = splits[0];
                String productName = splits[1];
                int productPrice = (int) (Double.parseDouble(splits[2]) * 100);
                String productCategory = splits[3];
                int productQuantity = 5;

                //create Product with new Product variables
                Product product = new Product(productName, productPrice, productCategory, productQuantity);

                inventory.put(slotID, product);
            }
        }
    }
}

