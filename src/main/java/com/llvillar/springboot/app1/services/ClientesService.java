package com.llvillar.springboot.app1.services;

import java.util.List;

import com.llvillar.springboot.app1.model.Cliente;


public interface ClientesService {
    public List<Cliente> findAll();
    public Cliente find(int codigo);
    public void save(Cliente cliente);
    public void update(Cliente cliente);
    public void delete(int codigo);
}
