package com.service;

import com.dao.DataAccess;
import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ProductService {
    @Autowired
    DataAccess DataAccess;

    public List<Product> getProducts() {
        return DataAccess.queryForProducts();
    }

    public Product getProduct(final Integer productId) {
        return DataAccess.queryForProduct(productId);
    }

}
