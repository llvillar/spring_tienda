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

import com.llvillar.springboot.app1.model.Nota;
import com.llvillar.springboot.app1.services.NotasService;

@Controller
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    NotasService notasService;

    @GetMapping(value = "/list")
    public ModelAndView listPage(Model model) {

        List<Nota> notas = notasService.findAll();

        ModelAndView modelAndView = new ModelAndView("notas/list");
        modelAndView.addObject("notas", notas);
        return modelAndView;
    }
    
    @GetMapping(path = { "/edit/{id}" })
    public ModelAndView edit(
            @PathVariable(name = "id", required = true) int id) {

        Nota nota = notasService.find(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("nota", nota);
        modelAndView.setViewName("notas/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Nota nota) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("nota", new Nota());
        modelAndView.setViewName("notas/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Nota nota) {

        Nota save = notasService.save(nota);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + save.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Nota nota) {

        notasService.update(nota);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + nota.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{id}" })
    public ModelAndView delete(
            @PathVariable(name = "id", required = true) int id) {

        notasService.delete(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}