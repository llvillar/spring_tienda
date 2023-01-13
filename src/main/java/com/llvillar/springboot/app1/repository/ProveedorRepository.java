package com.llvillar.springboot.app1.repository;

import org.springframework.data.repository.CrudRepository;

import com.llvillar.springboot.app1.model.Proveedor;

public interface ProveedorRepository extends CrudRepository<Proveedor, Integer>{
    
}
