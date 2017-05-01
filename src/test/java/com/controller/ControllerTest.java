package com.controller;

import com.exceptions.ItemNotAddedToDatabaseException;
import com.exceptions.ItemNotDeletedFromDatabaseException;
import com.exceptions.NoMatchedItemsForUserException;
import com.exceptions.ProductNotFoundException;
import com.model.Cart;
import com.model.Product;
import com.service.CartService;
import com.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class ControllerTest {

    @InjectMocks
    private Controller controller;
    @Mock
    private ProductService productService;
    @Mock
    private CartService cartService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testGetProducts() throws Exception {
        when(productService.getProducts()).thenReturn(Arrays.asList(new Product()));
        final List<Product> products = controller.getProducts();
        assertEquals(products, Arrays.asList(new Product()));
    }

    @Test(expected = ProductNotFoundException.class)
    public void testGetProductsWithException() throws Exception {
        when(productService.getProducts()).thenReturn(null);
        controller.getProducts();
    }


    @Test
    public void testGetProduct() throws Exception {
        when(productService.getProduct(anyInt())).thenReturn(new Product());
        final Product product = controller.getProduct(2);
        assertEquals(product, new Product());
    }

    @Test(expected = ProductNotFoundException.class)
    public void testGetProductWithException() throws Exception {
        when(productService.getProduct(anyInt())).thenReturn(null);
        controller.getProduct(2);
    }

    @Test
    public void testShowCart() throws Exception {
        final Cart expectedCart = new Cart();
        expectedCart.setProducts(Arrays.asList(new Product()));
        when(cartService.showCart(anyInt())).thenReturn(expectedCart);
        final Cart ActualCart = controller.showCart(2);
        assertEquals(ActualCart, expectedCart);
    }

    @Test(expected = NoMatchedItemsForUserException.class)
    public void testShowCartWithException() throws Exception {
        when(cartService.showCart(anyInt())).thenReturn(new Cart());
        controller.showCart(2);
    }

    @Test
    public void testAddItemToCart() throws Exception {
        when(cartService.addItemToCart(anyInt(), anyInt())).thenReturn(true);
        final String itemAdded = controller.addItemToCart(2, 3);
        assertEquals(itemAdded, "Item with productId:3 successfully added to the cart with userId:2");
    }

    @Test(expected = ItemNotAddedToDatabaseException.class)
    public void testAddItemToCartWithException() throws Exception {
        when(cartService.addItemToCart(anyInt(), anyInt())).thenReturn(false);
        controller.addItemToCart(2, 3);
    }

    @Test
    public void testRemoveItemToCart() throws Exception {
        when(cartService.deleteItemFromCart(anyInt(), anyInt())).thenReturn(true);
        final String itemAdded = controller.removeItemToCart(2, 3);
        assertEquals(itemAdded, "Item with productId:3 successfully removed from the cart with userId:2");
    }

    @Test(expected = ItemNotDeletedFromDatabaseException.class)
    public void testRemoveItemToCartWithException() throws Exception {
        when(cartService.deleteItemFromCart(anyInt(), anyInt())).thenReturn(false);
        controller.removeItemToCart(2, 3);
    }
}