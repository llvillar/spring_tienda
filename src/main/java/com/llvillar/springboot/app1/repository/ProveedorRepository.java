package com.llvillar.springboot.app1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.llvillar.springboot.app1.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
    
}
