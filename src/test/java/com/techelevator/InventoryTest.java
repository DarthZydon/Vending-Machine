package com.techelevator;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void load() throws FileNotFoundException {
        Inventory inventoryTest = new Inventory();
        Map<String, Product> inventoryMap = inventoryTest.getInventory();
        assertEquals(0, inventoryMap.size());
        inventoryTest.load();
        assertEquals(16, inventoryMap.size());
        Product product = inventoryMap.get("A1");
        assertEquals("Potato Crisps", product.getName());
        assertEquals("Cola", inventoryMap.get("C1").getName());
        assertEquals(125, inventoryMap.get("C1").getPrice());

    }
}