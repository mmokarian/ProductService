package com.controller;

import com.exceptions.ItemNotAddedToDatabaseException;
import com.exceptions.ItemNotDeletedFromDatabaseException;
import com.exceptions.NoMatchedItemsForUserException;
import com.exceptions.ProductNotFoundException;
import com.model.Cart;
import com.model.Product;
import com.service.CartService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class Controller {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/products", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts() {
        final List<Product> products = productService.getProducts();
        if (products == null || CollectionUtils.isEmpty(products)) throw new ProductNotFoundException();
        return products;
    }

    @RequestMapping(value = "/product/{productId}", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable(value = "productId") final Integer productId) {
        final Product products = productService.getProduct(productId);
        if (products == null) throw new ProductNotFoundException();
        return products;
    }

    @RequestMapping(value = "/cart/{userId}", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart showCart(@PathVariable(value = "userId") final Integer productId) {
        final Cart cart = cartService.showCart(productId);
        if (cart.getProducts().size() == 0) throw new NoMatchedItemsForUserException(productId);
        return cart;
    }

    @RequestMapping(value = "/cart/add/{userId}/{productId}", method = {RequestMethod.PUT})
    public String addItemToCart(@PathVariable(value = "userId") final Integer userId,
                                @PathVariable(value = "productId") final Integer productId) {
        final boolean itemAdded = cartService.addItemToCart(userId, productId);
        if (!itemAdded) {
            throw new ItemNotAddedToDatabaseException(userId, productId);
        } else {
            return "Item with productId:" + productId + " successfully added to the cart with userId:" + userId;
        }
    }

    @RequestMapping(value = "/cart/remove/{userId}/{productId}", method = {RequestMethod.DELETE})
    public String removeItemToCart(@PathVariable(value = "userId") final Integer userId,
                                   @PathVariable(value = "productId") final Integer productId) {
        final boolean itemDeleted = cartService.deleteItemFromCart(userId, productId);
        if (!itemDeleted) {
            throw new ItemNotDeletedFromDatabaseException(userId, productId);
        } else {
            return "Item with productId:" + productId + " successfully removed from the cart with userId:" + userId;
        }
    }


}
