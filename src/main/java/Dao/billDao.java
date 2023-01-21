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
import model.Bill;
import model.Product;
import model.User;

/**
 *
 * @author chabd
 */
public class billDao {

    public static String getId() {
        int id = 1;
        try {
            ResultSet rs = dbOperations.getData("select max(id) from bill");
            if (rs.next()) {
                id = rs.getInt(1);
                id = id + 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return String.valueOf(id);
    }

    public static void save(Bill bill) {
        String query = "INSERT INTO `bill`(`id`, `name`, `mobileNumber`, `email`, `date`, `total`, `createBy`) VALUES ('" + bill.getId() + "','" + bill.getName() + "','" + bill.getMobileNumber() + "','" + bill.getEmail() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreateBy() + "')";
        dbOperations.setDataorDelete(query, "Bill Details Added Successfully.");
    }

    public static ArrayList<Bill> getAllRecordsByInc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = dbOperations.getData("Select * from bill where date like '%" + date + "%'");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreateBy(rs.getString("createBy"));
                arrayList.add(bill);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayList;
    }
    
    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            ResultSet rs = dbOperations.getData("Select * from bill where date like '%" + date + "%' order by id DESC");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setName(rs.getString("name"));
                bill.setMobileNumber(rs.getString("mobileNumber"));
                bill.setEmail(rs.getString("email"));
                bill.setDate(rs.getString("date"));
                bill.setTotal(rs.getString("total"));
                bill.setCreateBy(rs.getString("createBy"));
                arrayList.add(bill);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arrayList;
    }
}
