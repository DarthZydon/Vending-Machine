package com.techelevator;

import com.techelevator.Product;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

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
    @Test
    public void reduceCount() {
        Product product = new Product("someProduct", 200, "Chip", 2);
        assertEquals(2, product.getCount());
        assertEquals(1, product.reduceCount());
        assertEquals(1, product.getCount());


    }

}