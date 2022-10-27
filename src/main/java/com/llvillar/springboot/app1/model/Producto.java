package com.llvillar.springboot.app1.model;

import java.util.Date;

public class Producto {
    private int codigo;
    private String nombre;
    private String descripcion;
    private String urlImg;
    private Date fecha;

    public Producto() {
    }

    
    public Producto(int codigo) {
        this.codigo = codigo;
    }

    public Producto(int codigo, String nombre, String descripcion, String urlImg, Date fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
        this.fecha = fecha;
    }

    /**
     * @return int return the codigo
     */
    public int getCodigo() {
        return codigo;
    }
    
    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return String return the urlImg
     */
    public String getUrlImg() {
        return urlImg;
    }

    /**
     * @param urlImg the urlImg to set
     */
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    /**
     * @return Date return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }
}
