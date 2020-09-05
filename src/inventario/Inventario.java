/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import conexion.Conexion;
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
            hc = new Conexion();
            System.out.println("conectado main");
             ViewAdmin admin = new ViewAdmin();
                admin.show();

        } catch (Exception e) {
            System.out.println("ERROR AL INICIAR " + e);
        }
        
   
       
    }
    
}
