package com.llvillar.springboot.app1.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.llvillar.springboot.app1.model.Nota;
import com.llvillar.springboot.app1.services.NotasService;

@Service
public class NotasServiceImpl implements NotasService{

    @Value("${url.notas.rest.service}")
    String urlApi;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Nota> findAll() {

        Nota[] ca = restTemplate.getForObject(urlApi + "notas", Nota[].class);
        List<Nota> Notas = Arrays.asList(ca);
        return Notas;
    }

    @Override
    public Nota find(int id) {
        Nota nota = restTemplate.getForObject(urlApi + "notas/" + id, Nota.class);
        return nota;
    }

    @Override
    public Nota save(Nota nota) {
        Nota notaR = restTemplate.postForObject(urlApi + "notas", nota, Nota.class);
        return notaR;
        
    }

    @Override
    public void update(Nota nota) {
        restTemplate.put(urlApi + "notas/" + nota.getCodigo(), nota);
        
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(urlApi + "notas/" + id);
        
    }
    
}
