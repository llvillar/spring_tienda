package com.llvillar.springboot.app1.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.llvillar.springboot.app1.dao.DetallePedidoDAO;
import com.llvillar.springboot.app1.dao.PedidosDAO;
import com.llvillar.springboot.app1.model.DetallePedido;
import com.llvillar.springboot.app1.model.Pedido;
import com.llvillar.springboot.app1.services.PedidosService;

@Service
public class PedidosServiceImpl implements PedidosService{

    @Autowired
    PedidosDAO pedidosDAO;

    @Autowired
    DetallePedidoDAO detallePedidoDAO;

    @Override
    public Page<Pedido> findAll(Pageable pageable) {
        return pedidosDAO.findAll(pageable);
    }

    @Override
    public Pedido find(int codigo) {
        return pedidosDAO.findById(codigo);
    }

    @Override
    public void save(Pedido pedido) {
        pedidosDAO.insert(pedido);

        List<DetallePedido> detallePedidos = pedido.getDetallePedidos();
        for (DetallePedido detallePedido : detallePedidos) {
            detallePedidoDAO.insert(pedido, detallePedido);
        }

    }

    @Override
    public void update(Pedido pedido) {
        pedidosDAO.update(pedido);
    }

    @Override
    public void delete(int codigo) {
        pedidosDAO.delete(codigo);        
    }
    
}