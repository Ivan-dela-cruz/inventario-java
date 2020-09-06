/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import conexion.Conexion;
import javax.swing.UIManager;
import views.Login;
import views.ViewAdmin;

/**
 *
 * @author ivan
 */
public class Inventario {

    /**
     * @param args the command line arguments
     */
    public static Conexion hc;

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            hc = new Conexion();
            System.out.println("conectado main");
            Login login = new Login();
            login.setVisible(true);

        } catch (Exception e) {
            System.out.println("ERROR AL INICIAR " + e);
        }

    }

}
