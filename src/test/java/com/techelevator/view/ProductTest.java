package com.techelevator.view;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void getName() {
        Product product = new Product("someProduct", 200, "Chip", 2);
        assertEquals("someProduct", product.getName());



    }

    @Test
    public void getPrice() {
    }

    @Test
    public void getCategory() {
    }

    @Test
    public void getCount() {
    }
}