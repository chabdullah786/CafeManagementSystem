/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileController;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chabd
 */
public class OpenPdf {

    public static void openById(String id) {

        if ((new File("D:\\" + id + ".pdf")).exists()) {
            try {
                Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler D:\\" + id + ".pdf");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "File Not Exists");
        }
    }
}
