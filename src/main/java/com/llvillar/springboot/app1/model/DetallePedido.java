package com.llvillar.springboot.app1.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DetallePedido {

    // @EmbeddedId
    // private DetallePedidoId id = new DetallePedidoId();

    @Id
    @GeneratedValue
    private int codigo;

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.MERGE)
    @MapsId("producto_codigo")
    private Producto producto;

    @ManyToOne(fetch = FetchType.EAGER, optional = true, cascade = CascadeType.MERGE)
    @MapsId("pedido_codigo")
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