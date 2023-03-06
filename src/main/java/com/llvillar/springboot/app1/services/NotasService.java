package com.llvillar.springboot.app1.services;

import java.util.List;

import com.llvillar.springboot.app1.model.Nota;


public interface NotasService {
    public List<Nota> findAll();
    public Nota find(int id);
    public Nota save(Nota nota);
    public void update(Nota nota);
    public void delete(int id);
}
