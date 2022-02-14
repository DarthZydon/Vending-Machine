package com.techelevator;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void getInventory()throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        Inventory inventory = vendingMachine.getInventory();
        inventory.load();
        assertEquals( 16, inventory.getInventory().size());
    }

    @Test
    public void feedMoney() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(0, vendingMachine.getCustomerBalance());
        vendingMachine.feedMoney(13);
        assertEquals(1300, vendingMachine.getCustomerBalance());
        vendingMachine.feedMoney(7);
        assertEquals(2000, vendingMachine.getCustomerBalance());
    }

    @Test
    public void getCustomerBalance() {
        VendingMachine vendingMachine = new VendingMachine();
        assertEquals(0, vendingMachine.getCustomerBalance());
        vendingMachine.feedMoney(15);
        assertEquals(1500, vendingMachine.getCustomerBalance());
    }

    @Test
    public void selectProduct()throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        Inventory inventory = vendingMachine.getInventory();
        inventory.load();
        vendingMachine.feedMoney(10);
        assertEquals( 16, inventory.getInventory().size());
        Product product = vendingMachine.selectProduct("A1");
        assertEquals("Potato Crisps", product.getName());
    }

    @Test
    public void finishTransaction() {
        VendingMachine vendingMachine = new VendingMachine();
        int change = vendingMachine.getCustomerBalance();
        vendingMachine.feedMoney(15);
        assertEquals(15, change);
        assertEquals(1500, vendingMachine.getCustomerBalance());


    }



    @Test
    public void selectProduct_notEnoughMoney()throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        Inventory inventory = vendingMachine.getInventory();
        inventory.load();
        assertEquals( 16, inventory.getInventory().size());
        try {
            Product product = vendingMachine.selectProduct("A1");
            fail("Expected Vend Exception");
        } catch (VendException e) {

        }

    }
}