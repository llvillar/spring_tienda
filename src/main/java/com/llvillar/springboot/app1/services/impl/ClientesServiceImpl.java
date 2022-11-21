package com.llvillar.springboot.app1.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llvillar.springboot.app1.dao.ClientesDAO;
import com.llvillar.springboot.app1.model.Cliente;
import com.llvillar.springboot.app1.services.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService{

    @Autowired
    ClientesDAO clientesDAO;

    @Override
    public List<Cliente> findAll() {
        return clientesDAO.findAll();
    }

    @Override
    public Cliente find(int codigo) {
        return clientesDAO.findById(codigo);
    }

    @Override
    public void save(Cliente cliente) {
        clientesDAO.insert(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        clientesDAO.update(cliente);        
    }

    @Override
    public void delete(int codigo) {
        clientesDAO.delete(codigo);        
    }
    
}