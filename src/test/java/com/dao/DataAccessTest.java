package com.dao;

import com.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class DataAccessTest {

    @InjectMocks
    private DataAccess dataAccess;
    @Mock
    private JdbcTemplate jdbcTemplate;
    private List<Product> expectedProducts;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        expectedProducts = Arrays.asList(new Product());
    }

    @Test
    public void testQueryForProducts() throws Exception {
        when(jdbcTemplate.query(anyString(), (Object[]) any(), any(RowMapper.class))).thenReturn(Arrays.asList(new Product()));
        final List<Product> actualProducts = dataAccess.queryForProducts();
        assertEquals(actualProducts, expectedProducts);
        assertEquals(actualProducts.size(), 1);
    }

    @Test
    public void testQueryForProduct() throws Exception {
        when(jdbcTemplate.query(anyString(), (Object[]) any(), any(RowMapper.class))).thenReturn(Arrays.asList(new Product()));
        final Product actualProducts = dataAccess.queryForProduct(12);
        assertEquals(actualProducts, expectedProducts.get(0));
    }

    @Test
    public void testQueryForCart() throws Exception {
        when(jdbcTemplate.query(anyString(), (Object[]) any(), any(RowMapper.class))).thenReturn(Arrays.asList(new Product()));
        final List<Product> actualProducts = dataAccess.queryForCart(12);
        assertEquals(actualProducts, expectedProducts);
        assertEquals(actualProducts.size(), 1);
    }

    @Test
    public void testAddItemToCart() throws Exception {
        when(jdbcTemplate.update(anyString(), new Object[]{any(), any()})).thenReturn(1);
        final boolean itemsAdded = dataAccess.addItemToCart(1, 1);
        assertTrue(itemsAdded);
    }

    @Test
    public void testAddItemToCartForFalseScenario() throws Exception {
        when(jdbcTemplate.update(anyString(), (Object[]) any())).thenReturn(0);
        final boolean itemsAdded = dataAccess.addItemToCart(1, 1);
        assertFalse(itemsAdded);
    }

    @Test
    public void testDeleteItemFromCart() throws Exception {
        when(jdbcTemplate.update(anyString(), new Object[]{any(), any()})).thenReturn(1);
        final boolean itemsAdded = dataAccess.deleteItemFromCart(1, 1);
        assertTrue(itemsAdded);
    }

    @Test
    public void testDeleteItemFromCartForFalseScenario() throws Exception {
        when(jdbcTemplate.update(anyString(), (Object[]) any())).thenReturn(0);
        final boolean itemsAdded = dataAccess.deleteItemFromCart(1, 1);
        assertFalse(itemsAdded);
    }

}