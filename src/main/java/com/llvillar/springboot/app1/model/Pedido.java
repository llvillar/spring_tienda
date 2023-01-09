package com.llvillar.springboot.app1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private long codigo;
    private double total;
    private Date fecha;
    private Cliente cliente;
    private List<DetallePedido> detallePedidos;
    
    public Pedido() {
        this.cliente = new Cliente();
        this.detallePedidos = new ArrayList<DetallePedido>();
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getTotal() {

        total = 0;
        for (DetallePedido detalle : this.detallePedidos) {
            total += detalle.getCantidad()*detalle.getProducto().getPrecio();
        }

        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(List<DetallePedido> detallePedidos) {
        this.detallePedidos = detallePedidos;
    }
}