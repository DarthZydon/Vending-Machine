package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory {

    public static final String FILEPATH = "vendingmachine.csv";
    public Map<String, Product> inventoryMap = new TreeMap<>();
    File userInputFile = new File(FILEPATH);

    public Inventory() {
    }

    public void load() throws FileNotFoundException {
        try (Scanner fileScanner = new Scanner(userInputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] splits = line.split("\\|");
                int money = (int) (Double.parseDouble(splits[2]) * 100);
                Product newProduct = new Product(splits[1], money, splits[3], 5);
                inventoryMap.put(splits[0], newProduct);
            }
        }
    }

    public Map<String, Product> getInventoryMap() throws FileNotFoundException {
        return inventoryMap;

    }
}
