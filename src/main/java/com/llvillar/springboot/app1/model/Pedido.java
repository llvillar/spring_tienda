package com.llvillar.springboot.app1.model;

import java.util.Date;
import java.util.List;

public class Pedido {

    private long codigo;
    private double total;
    private Date fecha;
    private Cliente cliente;
    private List<ProductoCesta> productosCesta;
    
    public Pedido() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getTotal() {
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

    public List<ProductoCesta> getProductosCesta() {
        return productosCesta;
    }

    public void setProductosCesta(List<ProductoCesta> productosCesta) {
        this.productosCesta = productosCesta;
    }
}
