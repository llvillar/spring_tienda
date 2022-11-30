package com.llvillar.springboot.app1.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llvillar.springboot.app1.model.Cliente;
import com.llvillar.springboot.app1.model.Pedido;
import com.llvillar.springboot.app1.services.ClientesService;

@Controller
@RequestMapping("/cesta")
public class CestaController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    ClientesService clientesService;

    @GetMapping(value = { "/edit" })
    public ModelAndView cesta(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        Pedido pedido = (Pedido) session.getAttribute("pedido");

        modelAndView.addObject("pedido", pedido);
        modelAndView.setViewName("cesta/edit");
        return modelAndView;    
    }


    @GetMapping(value = { "/delete" })
    public ModelAndView delete(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        session.setAttribute("pedido", null);

        modelAndView.setViewName("redirect:edit");
        return modelAndView;    
    }

    @GetMapping(value = "/addCliente/{codigo}")
    public ModelAndView addCliente(
        @PathVariable(name = "codigo", required = true) int codigo, HttpSession session) {

            Cliente cliente = clientesService.find(codigo);

            Pedido pedido = (Pedido) session.getAttribute("pedido");

            if(pedido == null){
                pedido = new Pedido();
            }

            pedido.setCliente(cliente);

            session.setAttribute("pedido", pedido);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:edit");
            return modelAndView;
    }

}
