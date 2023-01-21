/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Category;

/**
 *
 * @author chabd
 */
public class userDao {

    public static void save(User user) {
        String query = "INSERT INTO `user`(`name`, `email`, `mobileNumber`, `address`, `password`, `securityQuestion`, `answer`, `status`) VALUES ('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','" + user.getStatus() + "')";
        dbOperations.setDataorDelete(query, "Registration Successfully! Wait For Admin Approval.");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
                ResultSet rs = dbOperations.getData("select * from user where email='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = dbOperations.getData("select * from user where email = '" + email + "'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static void update(String email, String newPassword) {
        String query = "update user set password='" + newPassword + "' where email='" + email + "'";
        dbOperations.setDataorDelete(query, "Password Change Successfully.");
    }

    public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> arrayList = new ArrayList<>();
        try {
            ResultSet rs = dbOperations.getData("Select * from user where email like '%" + email + "%'");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayList;
    }

    public static void changeStatus(String email, String status) {

        String query = "update user set status='" + status + "' where email='" + email + "'";
        dbOperations.setDataorDelete(query, "Status Change Successfully.");
    }

    public static void changePassword(String email, String oldPassword, String newPassword) {

        try {
            ResultSet rs = dbOperations.getData("select * from user where email = '" + email + "' and password='" + oldPassword + "'");
            if (rs.next()) {
                update(email, newPassword);
            } else {
                JOptionPane.showMessageDialog(null, "Old Password is Wrong");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer) {

        try {
            ResultSet rs = dbOperations.getData("select * from user where email = '" + email + "' and password='" + password + "'");
            if (rs.next()) {
                update(email, securityQuestion, answer);
            } else {
                JOptionPane.showMessageDialog(null, "Password is Wrong");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static void update(String email, String securityQuestion, String answer) {
        String query = "update user set securityQuestion='" + securityQuestion + "', answer='" + answer + "' where email='" + email + "'";
        dbOperations.setDataorDelete(query, "Security Question Change Successfully.");
    }

}
