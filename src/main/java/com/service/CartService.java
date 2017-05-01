package com.service;

import com.dao.DataAccess;
import com.model.Cart;
import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CartService {
    @Autowired
    DataAccess DataAccess;

    public Cart showCart(final Integer userId) {
        final Cart cart = new Cart();
        final List<Product> products = DataAccess.queryForCart(userId);
        cart.setProducts(products);
        cart.setUserId(userId);
        return cart;
    }

    public boolean addItemToCart(final Integer userId, final Integer productId) {
        return DataAccess.addItemToCart(userId, productId);
    }

    public boolean deleteItemFromCart(final Integer userId, final Integer productId) {
        return DataAccess.deleteItemFromCart(userId, productId);
    }
}
