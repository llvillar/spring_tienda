package com.llvillar.springboot.app1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.llvillar.springboot.app1.model.Permiso;


@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long>{
}
