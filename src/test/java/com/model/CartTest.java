package com.model;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CartTest {
    Cart cart;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
        final Product product1 = new Product();
        product1.setPrice(12.21);
        final Product product2 = new Product();
        product2.setPrice(5.0);

        cart.setProducts(Arrays.asList(product1, product2));
    }

    @Test
    public void testGetTotalPrice() throws Exception {
        assertEquals(scale(cart.getTotalPrice()), scale(new BigDecimal(17.21)));
    }

    private BigDecimal scale(final BigDecimal bigDecimal) {
        return bigDecimal.setScale(2, RoundingMode.FLOOR);
    }
}