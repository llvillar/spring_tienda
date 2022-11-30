package com.llvillar.springboot.app1.model;

public class ProductoCesta {

    private Producto producto;
    private int cantidad;
    
    public ProductoCesta() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}