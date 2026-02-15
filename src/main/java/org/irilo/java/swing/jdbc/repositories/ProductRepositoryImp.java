package org.irilo.java.swing.jdbc.repositories;

import org.irilo.java.swing.jdbc.db.ConnectionJdbc;
import org.irilo.java.swing.jdbc.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImp implements ProductRepository {

    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        try (Connection conn = ConnectionJdbc.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {
            while (rs.next()) {
                Product product = new Product(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("quantity"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product findById(Long id) {
        Product product = null;

        try (Connection conn = ConnectionJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE id=?");
        ) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    product = new Product(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getInt("quantity"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product save(Product product) {
        Product productNew = null;
        String sql = "";
        if (product.getId() != null && product.getId() > 0) {
            sql = "UPDATE products set name=?, price=?, quantity=? where id=?";
        } else {
            sql = "insert into products(name,price,quantity) values(?,?,?)";
        }
        try (Connection conn = ConnectionJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());
            if (product.getId() != null && product.getId() > 0) {
                stmt.setLong(4, product.getId());
            }
            int affectedRow = stmt.executeUpdate();
            if (affectedRow>0 && (product.getId() == null || product.getId() == 0)) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        product.setId(rs.getLong(1));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void delete(Long id) {
        try (Connection conn = ConnectionJdbc.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM products WHERE id=?");
        ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
