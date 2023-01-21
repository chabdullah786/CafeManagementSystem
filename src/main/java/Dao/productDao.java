/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Category;
import model.Product;

/**
 *
 * @author chabd
 */
public class productDao {

    public static void save(Product product) {
        String query = "INSERT INTO `product`(name,category,price) VALUES ('" + product.getName() + "','" + product.getCategory() + "','" + product.getPrice() + "')";
        dbOperations.setDataorDelete(query, "Product Added Successfully.");
    }

    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> arrayList = new ArrayList<>();

        try {
            ResultSet rs = dbOperations.getData("Select * from product");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));

                arrayList.add(product);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayList;
    }

    public static void update(Product product) {
        String query = "update product set name='" + product.getName() + "',category='" + product.getCategory() + "',price='" + product.getPrice() + "' where id='" + product.getId() + "'";
        dbOperations.setDataorDelete(query, "Product Updated Successfully.");
    }

    public static void delete(String id) {
        String query = "delete from product where id='" + id + "'";
        dbOperations.setDataorDelete(query, "Product Deleted Successfully.");
    }

    public static ArrayList<Product> getAllRecordsByCategory(String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = dbOperations.getData("Select * from product where category='" + category + "'");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayList;
    }

    public static ArrayList<Product> filterProductByname(String name, String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = dbOperations.getData("Select * from product where name like '%" + name + "%' and category='" + category + "'");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayList;
    }

    public static Product getProductByname(String name) {

        Product product = new Product();
        try {
            ResultSet rs = dbOperations.getData("Select * from product where name='" + name + "'");
            while (rs.next()) {
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return product;
    }

}
