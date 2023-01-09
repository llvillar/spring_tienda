package com.llvillar.springboot.app1.dao;

import com.llvillar.springboot.app1.model.DetallePedido;
import com.llvillar.springboot.app1.model.Pedido;

public interface DetallePedidoDAO {
    
    public void insert(Pedido pedido, DetallePedido detallePedido);

}