package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Inventory {

    private static final String FILEPATH = "vendingmachine.csv";
    public Map<String, Product> inventoryMap = new TreeMap<>();

    public void load() throws FileNotFoundException {

        File userInputFile = new File(FILEPATH);

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

    public Map<String, Product> inventory = inventoryMap;


    public Map<String, Product> getInventoryMap() {
        return inventoryMap;
    }
}

//
//
//    public static void main(String[] args) {
//
//
//            String filePath = "C:\\Users\\Student\\workspace\\java-capstone-module-1-team-6\\vendingmachine.csv";
//
//            String contents = null;
//
//            try {
//                contents = new String(Files.readAllBytes(Paths.get(filePath)));
//
//                String[] fruits = contents.split("\\|");
//
//            for(String fruit : fruits) {
//                System.out.println(fruits[0]);
////                Product newProduct = Product(String fruits[1],fruits[2],fruits[3],5)
//                inventoryMap.put(fruits[0],Product);
//                }
//
//            } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//    }

//        Scanner userInput = new Scanner(System.in);
//
//        File userInputFile = new File("vendingmachine.csv");
//
//        String key;
//
//        Map<String, Product> inventoryMap = new TreeMap<>();
//        List<String> contents = new ArrayList<>();
//        contents.toArray();
//
//        try (Scanner fileScanner = new Scanner(userInputFile)) {
//            while (fileScanner.hasNextLine()) {
//                String line = fileScanner.nextLine();
//                line.split("\\r?\\n");
//                inventoryList.add(line);
////            }
//        } catch (FileNotFoundException e) {
//            System.out.println("SOLD OUT" + e.getMessage());
//        }
//        System.out.println(inventoryList);
//

//    }
//}