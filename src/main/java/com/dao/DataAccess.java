package com.dao;

import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class DataAccess {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> queryForProducts() {
        return jdbcTemplate.query("SELECT id,name,price FROM product;", new Object[]{}, mapRowForCatalog());

    }

    public Product queryForProduct(final Integer productId) {
        final String query = "SELECT * FROM product where id = ?";
        final List<Product> products = jdbcTemplate.query(query, new Object[]{productId}, mapRowForProducts());
        return CollectionUtils.isEmpty(products) ? null : products.get(0);
    }

    public List<Product> queryForCart(final Integer userId) {
        final String query = "select * from product where id in( Select productid from cart where userid=?)";
        final List<Product> products = jdbcTemplate.query(query, new Object[]{userId}, mapRowForProducts());
        return products;
    }

    public boolean addItemToCart(final Integer userId, final Integer productId) {
        final String query = " INSERT INTO cart (userid, productid) VALUES (?,?)";
        return (jdbcTemplate.update(query, new Object[]{userId, productId}) > 0);
    }

    public boolean deleteItemFromCart(final Integer userId, final Integer productId) {
        final String query = " DELETE from cart where userid = ? and productid =?";
        return (jdbcTemplate.update(query, new Object[]{userId, productId}) > 0);
    }

    public RowMapper<Product> mapRowForProducts() {
        return (resultSet, i) -> {
            final Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getDouble("price"));
            product.setDescription(resultSet.getString("description"));
            return product;
        };
    }

    public RowMapper<Product> mapRowForCatalog() {
        return (resultSet, i) -> {
            final Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setPrice(resultSet.getDouble("price"));
            return product;
        };
    }


}
