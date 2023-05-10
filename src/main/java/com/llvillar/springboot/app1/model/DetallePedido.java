package com.llvillar.springboot.app1.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class DetallePedido {

    // @EmbeddedId
    // private DetallePedidoId id = new DetallePedidoId();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "producto_codigo")
    private Producto producto;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pedido_codigo")
    private Pedido pedido;
    

    private int cantidad;
    private float subtotal;
    
    public DetallePedido() {
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

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }



    public Pedido getPedido() {
        return pedido;
    }


    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    // public DetallePedidoId getId() {
    //     return id;
    // }


    // public void setId(DetallePedidoId id) {
    //     this.id = id;
    // }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

}