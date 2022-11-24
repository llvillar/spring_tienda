package com.llvillar.springboot.app1.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llvillar.springboot.app1.dao.ProductosDAO;
import com.llvillar.springboot.app1.model.Producto;
import com.llvillar.springboot.app1.services.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService{

    @Autowired
    ProductosDAO productosDAO;

    @Override
    public List<Producto> findAll() {
        return productosDAO.findAll();
    }

    @Override
    public Producto find(int codigo) {
        return productosDAO.findById(codigo);
    }

    @Override
    public void save(Producto producto) {
        productosDAO.insert(producto);
    }

    @Override
    public void update(Producto producto) {
        productosDAO.update(producto);
        
        if(producto.getImage() != null && producto.getImage().length > 0 ){
            productosDAO.updateImage(producto);
        }
    }

    @Override
    public void delete(int codigo) {
        productosDAO.delete(codigo);        
    }
    
}