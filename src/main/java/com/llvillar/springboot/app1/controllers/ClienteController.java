package com.llvillar.springboot.app1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llvillar.springboot.app1.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView("clientes/list");
        modelAndView.addObject("clientes", getClientes());
        modelAndView.addObject("title", "clientes");
        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cliente", getCliente(codigo));
        modelAndView.setViewName("clientes/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Cliente cliente) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cliente", new Cliente());
        modelAndView.setViewName("clientes/edit");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Cliente cliente) {

        List<Cliente> clientes = getClientes();
        clientes.add(cliente);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Cliente cliente) {

        List<Cliente> clientes = getClientes();
        clientes.add(cliente);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("clientes", clientes);
        modelAndView.setViewName("clientes/list");
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cliente", getCliente(codigo));
        modelAndView.setViewName("clientes/edit");
        return modelAndView;
    }
        

    private Cliente getCliente(int codigo){
        List<Cliente> clientes = getClientes();
        int indexOf = clientes.indexOf(new Cliente(codigo));

        return clientes.get(indexOf);

    }

    private List<Cliente> getClientes() {

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        clientes.add(new Cliente(1, "Antonio", "Molina", "your@gmail.com","12345678Z", "555 777 8987","C/Melancolia, 12,1C", false));
        clientes.add(new Cliente(2, "Maria", "Zambrano", null, "12345678Z", "555 777 8987","C/Melancolia, 12,1C", true));
        clientes.add(new Cliente(3, "Lorenzo", "Lamas", "your@gmail.com", "12345678Z", "555 777 8987","C/Melancolia, 12,1C", false));
        clientes.add(new Cliente(4, "Andrés", "Segovia", "your@gmail.com", "12345678Z", "555 777 8987","C/Melancolia, 12,1C", false));

        return clientes;

    }

}
