/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * Factura.java
 *
 * Created on 08-abr-2013, 18:16:22
 */
package views;

import conexion.Conexion;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static views.ViewAdmin.reloj;

/**
 *
 * @author Administrador
 */
public class SalidaMateriasPrimas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Factura
     */
    public static Connection sql;
    public static Statement s;

    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;

    public SalidaMateriasPrimas() {
        initComponents();

        this.setLocation(25, 15);
        txtcodigo_s.requestFocus();
        txtfec.setEnabled(false);
        txtfec.setDisabledTextColor(Color.blue);
        txtfec.setText(fechaactual());
        cargar(txtfec.getText());
        txtcodigo_s.requestFocus();

    }

    void cargar(String fecha) {
        DefaultTableModel modelo = new DefaultTableModel();
        // String mostrar = "SELECT * FROM entradas WHERE CONCAT(ci,cod_barras,hora_llegada,hora_salida,fecha,estado,numero,placa) LIKE '%" + fecha + "%'";
        String mostrar = "SELECT materias.codigo,materias.nombre,salidas_materias.descripcion,salidas_materias.cantidad,salidas_materias.fecha,salidas_materias.hora  FROM salidas_materias,materias WHERE salidas_materias.id_materia=materias.id AND fecha='" + fecha + "'";
        String[] Titulos = {"CÓDIGO", "MATERIA", "OBSERVACIÓN", "CANTIDAD", "FECHA", "HORA"};
        modelo.setColumnIdentifiers(Titulos);
        this.tbsalidas.setModel(modelo);

        Conexion j = new Conexion();
        j.conectar();
        sql = j.sql;

        try {

            String[] registros = new String[6];
            s = sql.createStatement();
            ResultSet rs = s.executeQuery(mostrar);

            while (rs.next()) {
                registros[0] = rs.getString("codigo");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("descripcion");
                registros[3] = rs.getString("cantidad");
                registros[4] = rs.getString("fecha");
                registros[5] = rs.getString("hora");

                modelo.addRow(registros);
            }
            tbsalidas.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actualizarStock() {
        try {
            int total = Integer.parseInt(txtstock_s.getText().toString());
            total = total - Integer.parseInt(sp_cantidad.getValue().toString());
            Conexion j = new Conexion();
            j.conectar();
            j.editar("UPDATE materias SET stock='" + total + "' WHERE codigo='" + txtcodigo_s.getText().toString() + "'");

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    void getHora(String hour) {
        int decimal;
        int unidad;
        int horass = 0;
        String tiempo = "";
        String c = "";
        try {

            c = hour;
            System.out.println("resultado " + c);

            char r1 = c.charAt(0);
            char r2 = c.charAt(1);
            char r3 = c.charAt(9);
            char r4 = c.charAt(10);

            tiempo = "" + r3 + r4;

            decimal = Integer.parseInt(String.valueOf(r1)) * 10;
            unidad = Integer.parseInt(String.valueOf(r1));
            horass = decimal + unidad;
            if (tiempo.equals("PM")) {
                horass = horass + 12;
                txhora.setText(String.valueOf(horass));
            } else {
                txhora.setText(String.valueOf(horass));
            }
        } catch (Exception ex) {
            System.out.println(ex);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtnom_s = new javax.swing.JTextField();
        btnclientes = new javax.swing.JButton();
        txtstock_s = new javax.swing.JTextField();
        txtcodigo_s = new javax.swing.JTextField();
        txhora = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtfec = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtdes_s = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        sp_cantidad = new javax.swing.JSpinner();
        txtdescripcion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbsalidas = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Salidas de materias primas");
        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Materia:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 68, -1));

        txtnom_s.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnom_s.setForeground(new java.awt.Color(0, 51, 204));
        txtnom_s.setEnabled(false);
        txtnom_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom_sActionPerformed(evt);
            }
        });
        jPanel2.add(txtnom_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 13, 240, -1));

        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscar.png"))); // NOI18N
        btnclientes.setText("...");
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 13, -1, 25));

        txtstock_s.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtstock_s.setEnabled(false);
        jPanel2.add(txtstock_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 101, 240, -1));

        txtcodigo_s.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcodigo_s.setForeground(new java.awt.Color(51, 51, 255));
        txtcodigo_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigo_sActionPerformed(evt);
            }
        });
        txtcodigo_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigo_sKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigo_sKeyTyped(evt);
            }
        });
        jPanel2.add(txtcodigo_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 44, 240, -1));

        txhora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txhora.setEnabled(false);
        jPanel2.add(txhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 44, 106, -1));

        jLabel10.setText("Descripción:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 78, 64, -1));

        jLabel9.setText("Código:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 47, -1, -1));

        jLabel13.setText("Stock:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 104, 124, -1));

        jLabel12.setText("Fecha:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 18, 47, -1));
        jPanel2.add(txtfec, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 15, 106, -1));

        jLabel16.setText("Hora:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 47, 47, -1));

        txtdes_s.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtdes_s.setForeground(new java.awt.Color(51, 51, 255));
        txtdes_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdes_sActionPerformed(evt);
            }
        });
        txtdes_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdes_sKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdes_sKeyTyped(evt);
            }
        });
        jPanel2.add(txtdes_s, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 75, 240, -1));

        jLabel17.setText("Cantidad:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 73, -1, -1));

        sp_cantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100000, 1));
        jPanel2.add(sp_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 70, 106, -1));
        jPanel2.add(txtdescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 127, 490, -1));

        jLabel14.setText("Observación:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 130, 77, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plus.png"))); // NOI18N
        btnsalir.setText("Materia");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnguardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        tbsalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI", "Código", "Placa", "Estado", "Fecha", "Hora entrada", "Hora salida", "Entrada N°"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbsalidas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 78, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel2)
                        .addContainerGap(281, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        setBounds(0, 0, 830, 540);
    }// </editor-fold>//GEN-END:initComponents
public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatofecha.format(fecha);

    }
private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
// TODO add your handling code here:
    txhora.setText(reloj.getText());
    MateriasBuscar cli = new MateriasBuscar("SALIDA");
    ViewAdmin.jdpescritorio.add(cli);
    cli.toFront();
    cli.setVisible(true);


}//GEN-LAST:event_btnclientesActionPerformed

private void txtnom_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom_sActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtnom_sActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
    try {
        MateriasPrima ingcli = new MateriasPrima();
        ViewAdmin.jdpescritorio.add(ingcli);
        ingcli.toFront();
        ingcli.setVisible(true);
        this.dispose();

    } catch (Exception e) {
    }
}//GEN-LAST:event_btnsalirActionPerformed

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
    String cod, fech, nom, horaa, descrip, cantidad;
    int id_tabla = 0;

    descrip = txtdescripcion.getText().toString();
    fech = txtfec.getText().toUpperCase();
    horaa = txhora.getText().toUpperCase();
    cantidad = sp_cantidad.getValue().toString();
    if (txtcodigo_s.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "REVISE  LOS CAMPOS O  EL REGISTRO NO ESTA REGISTRADO");
    } else {
        try {
            id_tabla = Integer.parseInt(BuscarMateria(txtcodigo_s.getText().toString()));
            int cantidad_restar = Integer.parseInt(sp_cantidad.getValue().toString());
            int stock_encontrado = Integer.parseInt(txtstock_s.getText().toString());

            if (cantidad_restar > stock_encontrado) {
                JOptionPane.showMessageDialog(null, "La cantidad supera el stock actual");
            } else {
                if (id_tabla != 0) {
                    Conexion j = new Conexion();
                    j.conectar();
                    String sql = "INSERT INTO salidas_materias(id_materia,descripcion,cantidad,fecha,hora) VALUES('"
                            + id_tabla + "','"
                            + descrip + "','"
                            + cantidad + "','"
                            + fech + "','"
                            + horaa + "')";
                    j.insertar(sql);
                    JOptionPane.showMessageDialog(null, "Guardado exitosamente");
                    actualizarStock();
                    limpiar();
                    cargar(txtfec.getText());
                    txtcodigo_s.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(null, "Registro no encontrado");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en el código");
        }

    }

}//GEN-LAST:event_btnguardarActionPerformed

    private void txtcodigo_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigo_sKeyReleased
//        String datos[] = new String[9];
//
//        datos = getCliente(txtci.getText());
//        txhora.setText(reloj.getText());
//        txtcod.setText(datos[0]);
//        txtci.setText(datos[1]);
//        txtnomape.setText(datos[2]+" "+datos[3]);
//        txtplaca.setText(datos[4]);


    }//GEN-LAST:event_txtcodigo_sKeyReleased

    private void txtcodigo_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigo_sActionPerformed
        String datos[] = new String[4];

        datos = getMateria(txtcodigo_s.getText());
        txhora.setText(reloj.getText());
        txtcodigo_s.setText(datos[0]);
        txtnom_s.setText(datos[1]);
        txtdes_s.setText(datos[2]);
        txtstock_s.setText(datos[3]);
    }//GEN-LAST:event_txtcodigo_sActionPerformed

    private void txtcodigo_sKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigo_sKeyTyped
        char car = evt.getKeyChar();
        if (txtcodigo_s.getText().length() > 10) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcodigo_sKeyTyped

    private void txtdes_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdes_sActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdes_sActionPerformed

    private void txtdes_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdes_sKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdes_sKeyReleased

    private void txtdes_sKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdes_sKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdes_sKeyTyped

    public String BuscarMateria(String valor) {
        String val = "SELECT id FROM materias WHERE codigo = '" + valor + "'";

        Conexion j = new Conexion();
        String registros = "";
        j.conectar();

        sql = j.sql;
        try {
            s = sql.createStatement();
            ResultSet rs = s.executeQuery(val);
            while (rs.next()) {
                registros = rs.getString("id");
            }
            return registros;

        } catch (SQLException ex) {

            Logger.getLogger(ViewAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return registros;
        }

    }

    public String[] getMateria(String valor) {
        String mostrar = "SELECT * FROM materias WHERE codigo='" + valor + "' AND estado='ACTIVO'";
        Conexion j = new Conexion();
        String[] registros = new String[4];
        j.conectar();

        sql = j.sql;
        try {

            s = sql.createStatement();
            ResultSet rs = s.executeQuery(mostrar);
            while (rs.next()) {
                registros[0] = rs.getString("codigo");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("descripcion");
                registros[3] = rs.getString("stock");
            }

            return registros;

        } catch (SQLException ex) {

            Logger.getLogger(ViewAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return registros;

        }

    }

    public void limpiar() {
        txtcodigo_s.setText("");
        txtnom_s.setText("");
        txtdes_s.setText("");
        txtstock_s.setText("");
        txhora.setText("");
        sp_cantidad.setValue(1);
        txtdescripcion.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner sp_cantidad;
    public static javax.swing.JTable tbsalidas;
    public static javax.swing.JTextField txhora;
    public static javax.swing.JTextField txtcodigo_s;
    public static javax.swing.JTextField txtdes_s;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtfec;
    public static javax.swing.JTextField txtnom_s;
    public static javax.swing.JTextField txtstock_s;
    // End of variables declaration//GEN-END:variables

}
