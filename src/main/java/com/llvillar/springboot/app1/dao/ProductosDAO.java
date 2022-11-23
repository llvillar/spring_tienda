package com.llvillar.springboot.app1.dao;

import java.util.List;

import com.llvillar.springboot.app1.model.Producto;

public interface ProductosDAO {
    
    public List<Producto> findAll();
    public Producto findById(int codigo);
    public void insert(Producto Producto);
    public void update(Producto Producto);
    public void delete(int codigo);

}