    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author chabd
 */
public class connectionProvider {

    public static Connection db_Connect() {
        Connection con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false&allowPublicKeyRetrieval=true", "root", "");
            System.out.println("DB Connection Successful.");
        } catch (Exception ex) {
            System.out.println("DB Connection Error");
            JOptionPane.showConfirmDialog(null, ex);

        }
        return con;

    }
}
