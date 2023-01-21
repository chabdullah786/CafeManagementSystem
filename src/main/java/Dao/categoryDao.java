/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.ArrayList;
import model.Category;
import model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chabd
 */
public class categoryDao {

    public static void save(Category category) {
        String query = "INSERT INTO `category`(`name`) VALUES ('" + category.getName() + "')";
        dbOperations.setDataorDelete(query, "Category Added Successfully.");
    }

    public static ArrayList<Category> getAllRecords() {
        ArrayList<Category> arrayList = new ArrayList<>();

        try {
            ResultSet rs = dbOperations.getData("Select * from category");
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayList;
    }

    public static void delete(String id) {
        String query = "delete from category where id='" + id + "'";
        dbOperations.setDataorDelete(query, "Category Deleted Successfully.");
    }

}
