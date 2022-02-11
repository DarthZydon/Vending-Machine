package com.techelevator.view;

import com.techelevator.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void getName() {
        Product product = new Product("someProduct", 200, "Chip", 2);
        assertEquals("someProduct", product.getName());
        Product product1 = new Product("saucySnacks", 200, "Candy", 2);
        assertEquals("saucySnacks", product1.getName());



    }

    @Test
    public void getPrice() {
        Product product = new Product("someProduct", 200, "Chip", 2);
        assertEquals(200, product.getPrice());
        Product product1 = new Product("gooChews", 150, "Gum", 5);
        assertEquals(150, product1.getPrice());
    }

    @Test
    public void getCategory() {
        Product product = new Product("someProduct", 200, "Chip", 2);
        assertEquals("Chip", product.getCategory());
        Product product1 = new Product("GooChews", 150, "Gum", 5);
        assertEquals("Gum", product1.getCategory());
    }

    @Test
    public void getCount() {
        Product product = new Product("someProduct", 200, "Chip", 2);
        assertEquals(2, product.getCount());
        Product product1 = new Product("GooChews", 150, "Gum", 5);
        assertEquals(5, product1.getCount());
    }
}