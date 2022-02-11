package com.techelevator.view;

public class VendingMachine {

    private Inventory workingInventory;

    public VendingMachine() {}

    public VendingMachine(String inventoryFilePath) {
        this.workingInventory = new Inventory();
        
    }



}
