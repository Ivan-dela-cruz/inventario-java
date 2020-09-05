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
public class EntradaProductos extends javax.swing.JInternalFrame {

    /**
     * Creates new form Factura
     */
    public static Connection sql;
    public static Statement s;

    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;

    public EntradaProductos() {
        initComponents();

        this.setLocation(25, 15);
        txtcodigo.requestFocus();
        txtfec.setEnabled(false);
        txtfec.setDisabledTextColor(Color.blue);
        txtfec.setText(fechaactual());
        cargar(txtfec.getText());
        txtcodigo.requestFocus();

    }

    void cargar(String fecha) {
        DefaultTableModel modelo = new DefaultTableModel();
        // String mostrar = "SELECT * FROM entradas WHERE CONCAT(ci,cod_barras,hora_llegada,hora_salida,fecha,estado,numero,placa) LIKE '%" + fecha + "%'";
        String mostrar = "SELECT productos.codigo,productos.nombre,entradas_productos.descripcion,entradas_productos.cantidad,entradas_productos.fecha,entradas_productos.hora  FROM entradas_productos,productos WHERE entradas_productos.id_producto=productos.id AND fecha='" + fecha + "'";
        String[] Titulos = {"CÓDIGO", "PRODUCTO", "OBSERVACIÓN", "CANTIDAD", "FECHA", "HORA"};
        modelo.setColumnIdentifiers(Titulos);
        this.tbentradas.setModel(modelo);

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
            tbentradas.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void actualizarStock() {
        try {
            int total = Integer.parseInt(txtstock.getText().toString());
            total = total + Integer.parseInt(sp_cantidad.getValue().toString());
            Conexion j = new Conexion();
            j.conectar();
            j.editar("UPDATE productos SET stock='" + total + "' WHERE codigo='" + txtcodigo.getText().toString() + "'");

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
        txtnom = new javax.swing.JTextField();
        btnclientes = new javax.swing.JButton();
        txtstock = new javax.swing.JTextField();
        txtcodigo = new javax.swing.JTextField();
        txhora = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtfec = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        sp_cantidad = new javax.swing.JSpinner();
        txtdescripcion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbentradas = new javax.swing.JTable();

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
        setTitle("Entrada de productos");
        setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Materia:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 68, -1));

        txtnom.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnom.setForeground(new java.awt.Color(0, 51, 204));
        txtnom.setEnabled(false);
        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });
        jPanel2.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 13, 240, -1));

        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscar.png"))); // NOI18N
        btnclientes.setText("...");
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });
        jPanel2.add(btnclientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 13, -1, 25));

        txtstock.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtstock.setEnabled(false);
        jPanel2.add(txtstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 101, 240, -1));

        txtcodigo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcodigo.setForeground(new java.awt.Color(51, 51, 255));
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });
        jPanel2.add(txtcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 44, 240, -1));

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

        txtdes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtdes.setForeground(new java.awt.Color(51, 51, 255));
        txtdes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdesActionPerformed(evt);
            }
        });
        txtdes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdesKeyTyped(evt);
            }
        });
        jPanel2.add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 75, 240, -1));

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
        btnsalir.setText("Producto");
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

        tbentradas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbentradas);

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
                        .addGap(0, 77, Short.MAX_VALUE))))
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
    ProductosBuscar cli = new ProductosBuscar("ENTRADA");
    ViewAdmin.jdpescritorio.add(cli);
    cli.toFront();
    cli.setVisible(true);


}//GEN-LAST:event_btnclientesActionPerformed

private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtnomActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
    try {
        Productos ingcli = new Productos();
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
    if (txtcodigo.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "REVISE  LOS CAMPOS O  EL REGISTRO NO ESTA REGISTRADO");
    } else {
        try {
            id_tabla = Integer.parseInt(BuscarMateria(txtcodigo.getText().toString()));
            if (id_tabla != 0) {
                Conexion j = new Conexion();
                j.conectar();
                String sql = "INSERT INTO entradas_productos(id_producto,descripcion,cantidad,fecha,hora) VALUES('"
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
                txtcodigo.requestFocus();

            } else {
                JOptionPane.showMessageDialog(null, "Registro no encontrado");
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error en el código");
        }

    }

}//GEN-LAST:event_btnguardarActionPerformed

    private void txtcodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyReleased
//        String datos[] = new String[9];
//
//        datos = getCliente(txtci.getText());
//        txhora.setText(reloj.getText());
//        txtcod.setText(datos[0]);
//        txtci.setText(datos[1]);
//        txtnomape.setText(datos[2]+" "+datos[3]);
//        txtplaca.setText(datos[4]);


    }//GEN-LAST:event_txtcodigoKeyReleased

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        String datos[] = new String[4];

        datos = getMateria(txtcodigo.getText());
        txhora.setText(reloj.getText());
        txtcodigo.setText(datos[0]);
        txtnom.setText(datos[1]);
        txtdes.setText(datos[2]);
        txtstock.setText(datos[3]);
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        char car = evt.getKeyChar();
        if (txtcodigo.getText().length() > 10) {
            evt.consume();
        }
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtdesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdesActionPerformed

    private void txtdesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdesKeyReleased

    private void txtdesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdesKeyTyped

    public String BuscarMateria(String valor) {
        String val = "SELECT id FROM productos WHERE codigo = '" + valor + "'";

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
        String mostrar = "SELECT * FROM productos WHERE codigo='" + valor + "' AND estado='ACTIVO'";
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
        txtcodigo.setText("");
        txtnom.setText("");
        txtdes.setText("");
        txtstock.setText("");
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
    public static javax.swing.JTable tbentradas;
    public static javax.swing.JTextField txhora;
    public static javax.swing.JTextField txtcodigo;
    public static javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtfec;
    public static javax.swing.JTextField txtnom;
    public static javax.swing.JTextField txtstock;
    // End of variables declaration//GEN-END:variables

}
