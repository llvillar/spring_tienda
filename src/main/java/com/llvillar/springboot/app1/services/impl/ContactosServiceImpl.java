package com.llvillar.springboot.app1.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.llvillar.springboot.app1.model.Contacto;
import com.llvillar.springboot.app1.services.ContactosService;

@Service
public class ContactosServiceImpl implements ContactosService{

    @Value("${url.agenda.rest.service}")
    String urlAgenda;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Contacto> findAll() {

        Contacto[] ca = restTemplate.getForObject(urlAgenda + "contactos", Contacto[].class);
        List<Contacto> contactos = Arrays.asList(ca);
        return contactos;
    }

    @Override
    public Contacto find(int id) {
        Contacto contacto = restTemplate.getForObject(urlAgenda + "contactos/{id}", Contacto.class, id);
        return contacto;
    }


    @Override
    public void delete(int id) {
        restTemplate.delete(urlAgenda + "contactos/{id}", id);
        
    }

    @Override
    public void save(Contacto contacto) {
        Contacto contactoResponse = restTemplate.postForObject(urlAgenda + "contactos", contacto, Contacto.class);
        contacto.setId(contactoResponse.getId());
        
    }

    @Override
    public void update(Contacto contacto) {
        restTemplate.put(urlAgenda + "contactos/{id}", contacto, contacto.getId());
        
    }

    
}
