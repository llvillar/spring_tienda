package com.llvillar.springboot.app1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llvillar.springboot.app1.model.Contacto;
import com.llvillar.springboot.app1.services.ContactosService;

@Controller
@RequestMapping("/contactos")
public class ContactosController {

    @Autowired
    ContactosService contactosService;

    @GetMapping(value = "/list")
    public ModelAndView listPage(Model model) {

        List<Contacto> contactos = contactosService.findAll();

        ModelAndView modelAndView = new ModelAndView("contactos/list");
        modelAndView.addObject("contactos", contactos);
        return modelAndView;
    }
    
    @GetMapping(path = { "/edit/{id}" })
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) int id) {

        Contacto contacto = contactosService.find(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contacto", contacto);
        modelAndView.setViewName("contactos/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Contacto contacto) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contacto", new Contacto());
        modelAndView.setViewName("contactos/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Contacto contacto) {

        contactosService.save(contacto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + contacto.getId());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Contacto contacto) {

        contactosService.update(contacto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + contacto.getId());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{id}" })
    public ModelAndView delete(
            @PathVariable(name = "id", required = true) int id) {

        contactosService.delete(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}