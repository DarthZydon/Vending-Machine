package com.techelevator;

public class VendingMachine {

    private Inventory workingInventory;
    private int customerBalance = 0;
    private int machineBalance = 0;

    public VendingMachine(String inventoryFilePath) {
        this.workingInventory = new Inventory();
    }

    public Inventory getWorkingInventory() {
        return workingInventory;
    }

    public int feedMoney(int moneyEntered) {
        customerBalance += moneyEntered;
        return customerBalance;
    }

    public Product selectProduct(String slotID) throws VendExceptions {
        Product product = workingInventory.inventoryMap.get(slotID);
        if (customerBalance < product.getPrice()) {
            //customer doesn't have enough money
            throw new VendExceptions("You don't have enough money");
        }
        if (product.getCount() < 1) {
            //product is sold out
            throw new VendExceptions("SOLD OUT");

        }
        customerBalance -= product.getPrice();
        machineBalance += product.getPrice();
        product.reduceCount();

        return product;
    }

    public int finishTransaction() {
        int change = customerBalance;
        customerBalance = 0;
        return change;
    }



}
