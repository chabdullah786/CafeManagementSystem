/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chabd
 */
public class dbOperations {

    public static void setDataorDelete(String query, String msg) {

        try {
            Connection con = connectionProvider.db_Connect();
            PreparedStatement pst = con.prepareStatement(query);
            pst.execute();
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error Message", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static ResultSet getData(String query) {

        Statement st;
        try {
            Connection con = connectionProvider.db_Connect();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error Message", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }
}
