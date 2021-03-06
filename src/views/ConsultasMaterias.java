/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * ConsultasClientes.java
 *
 * Created on 15-abr-2013, 8:33:48
 */
package views;

import static com.itextpdf.text.pdf.PdfFileSpecification.url;
import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static inventario.Inventario.hc;
import java.io.InputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import reportes.ReporteMaterias;
import reportes.ReporteProductos;

/**
 *
 * @author Administrador
 */
public class ConsultasMaterias extends javax.swing.JInternalFrame {

    public static Connection sql;
    public static Statement s;

    public ConsultasMaterias() {
        initComponents();
        Cargarlistaclientes();
    }

    void Cargarlistaclientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] Titulos = {"CÓDIGO", "MATERIA PRIMA", "DESCRIPCIÓN", "CANTIDAD INICIAL", "STOCK", "ESTADO"};
        modelo.setColumnIdentifiers(Titulos);
        this.tbclientes.setModel(modelo);

        Conexion j = new Conexion();
        j.conectar();
        sql = j.sql;
        try {
            String[] registros = new String[6];
            s = sql.createStatement();
            String ConsultaSQL = "SELECT * FROM materias";
            ResultSet rs = s.executeQuery(ConsultaSQL);

            while (rs.next()) {
                registros[0] = rs.getString("codigo");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("descripcion");
                registros[3] = rs.getString("cantidad_inicial");
                registros[4] = rs.getString("stock");
                registros[5] = rs.getString("estado");
                modelo.addRow(registros);

            }
            tbclientes.setModel(modelo);
            txtcant.setText("" + tbclientes.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasMaterias.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdestado = new javax.swing.JRadioButton();
        rdtodo = new javax.swing.JRadioButton();
        btnbuscar = new javax.swing.JButton();
        cbfiltro = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtcant = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONSULTA DE MATERIAS PRIMAS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonGroup1.add(rdestado);
        rdestado.setSelected(true);
        rdestado.setText("Mostrar por estados:");
        rdestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdestadoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdtodo);
        rdtodo.setText("Mostrar todos los registros");
        rdtodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdtodoActionPerformed(evt);
            }
        });

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscar.png"))); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        cbfiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdestado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rdtodo))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdestado)
                    .addComponent(cbfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdtodo)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbclientes);

        jLabel1.setText("Cantidad de Registros");

        txtcant.setEnabled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print.png"))); // NOI18N
        jButton2.setText("Generar Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 191, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void rdestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdestadoActionPerformed
// TODO add your handling code here:
    if (rdestado.isSelected() == true) {

        cbfiltro.setSelectedItem(0);
        cbfiltro.setEnabled(true);
        
    }
}//GEN-LAST:event_rdestadoActionPerformed


private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
// TODO add your handling code here:
    String tipo = cbfiltro.getSelectedItem().toString();

    if (rdestado.isSelected() == true) {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] Titulos = {"CÓDIGO", "MATERIA PRIMA", "DESCRIPCIÓN", "CANTIDAD INICIAL", "STOCK", "ESTADO"};
        modelo.setColumnIdentifiers(Titulos);
        this.tbclientes.setModel(modelo);

        Conexion j = new Conexion();
        j.conectar();
        sql = j.sql;
        try {
            String[] registros = new String[6];
            s = sql.createStatement();
            String ConsultaSQL = "SELECT * FROM materias WHERE estado='" + tipo + "'";
            ResultSet rs = s.executeQuery(ConsultaSQL);

            while (rs.next()) {
               registros[0] = rs.getString("codigo");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("descripcion");
                registros[3] = rs.getString("cantidad_inicial");
                registros[4] = rs.getString("stock");
                registros[5] = rs.getString("estado");
                modelo.addRow(registros);

            }
            tbclientes.setModel(modelo);
            txtcant.setText("" + tbclientes.getRowCount());

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasMaterias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (rdtodo.isSelected() == true) {
        Cargarlistaclientes();
    }

}//GEN-LAST:event_btnbuscarActionPerformed

private void rdtodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdtodoActionPerformed
// TODO add your handling code here:
    Cargarlistaclientes();
    
}//GEN-LAST:event_rdtodoActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    try {
        // TODO add your handling code here:
        List<ReporteMaterias> listaclientes = new ArrayList<ReporteMaterias>();
        int filas = tbclientes.getRowCount();
        //String cod_barras, String ci, String nombre, String apellido, String direccion, String placa, String modelo, String color
        for (int i = 0; i < filas; i++) {
            ReporteMaterias p = new ReporteMaterias(
                    tbclientes.getValueAt(i, 0).toString(),
                    tbclientes.getValueAt(i, 1).toString(),
                    tbclientes.getValueAt(i, 2).toString(),
                    tbclientes.getValueAt(i, 3).toString(),
                    tbclientes.getValueAt(i, 4).toString(),
                    tbclientes.getValueAt(i, 5).toString()
            );
            listaclientes.add(p);
        }
        String tipo = cbfiltro.getSelectedItem().toString();
        String path = "src\\reportes\\ReportMateria.jasper";
       

        JasperReport reporte;
        reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
        Map parametros = new HashMap();
        parametros.put("estado",tipo);

        JasperPrint jasperPrint;
        jasperPrint = JasperFillManager.fillReport(reporte, parametros, new JRBeanCollectionDataSource(listaclientes));
        JasperViewer.viewReport(jasperPrint, false);
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("ReportMateria.pdf"));
        exporter.exportReport();
    } catch (JRException ex) {
        Logger.getLogger(ConsultasMaterias.class.getName()).log(Level.SEVERE, null, ex);
    }


}//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbfiltro;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdestado;
    private javax.swing.JRadioButton rdtodo;
    private javax.swing.JTable tbclientes;
    private javax.swing.JTextField txtcant;
    // End of variables declaration//GEN-END:variables

}
