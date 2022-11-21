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

import com.llvillar.springboot.app1.model.Cliente;
import com.llvillar.springboot.app1.services.ClientesService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClientesService clientesService;

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {

        List<Cliente> clientes = clientesService.findAll();

        ModelAndView modelAndView = new ModelAndView("clientes/list");
        modelAndView.addObject("clientes", clientes);
        modelAndView.addObject("title", "clientes");
        return modelAndView;
    }
    
    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Cliente cliente = clientesService.find(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cliente", cliente);
        modelAndView.setViewName("clientes/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Cliente cliente) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cliente", new Cliente());
        modelAndView.setViewName("clientes/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Cliente cliente) {

        clientesService.save(cliente);

        List<Cliente> clientes = clientesService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Cliente cliente) {


        clientesService.update(cliente);

        List<Cliente> clientes = clientesService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {


        clientesService.delete(codigo);
        List<Cliente> clientes = clientesService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");
        return modelAndView;
    }
}
