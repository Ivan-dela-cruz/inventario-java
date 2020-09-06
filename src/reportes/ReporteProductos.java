/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

/**
 *
 * @author ivan
 */
public class ReporteProductos {

    /*
    ci varchar(50) primary key NOT NULL,
  nombre text NOT NULL,
  apellido text NOT NULL,
  telefono text,
  direccion text,
  placa text NOT NULL,
  modelo text,
  color text,
  cod_barras varchar(200)
     */
    private String codigo;
    private String nombre;
    private String descripcion;
    private String cantidad_inicial;
    private String stock;
    private String estado;

    public ReporteProductos() {
    }

    public ReporteProductos(String codigo, String nombre, String descripcion, String cantidad_inicial, String stock, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad_inicial = cantidad_inicial;
        this.stock = stock;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad_inicial() {
        return cantidad_inicial;
    }

    public void setCantidad_inicial(String cantidad_inicial) {
        this.cantidad_inicial = cantidad_inicial;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    
    

}
