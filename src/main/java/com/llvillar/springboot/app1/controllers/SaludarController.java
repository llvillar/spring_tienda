package com.llvillar.springboot.app1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llvillar.springboot.app1.configuration.Views;
import com.llvillar.springboot.app1.model.Producto;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/saludar")
public class SaludarController {

    @GetMapping(value={"/hola","/buenas"})
    public String hola() {
        return "hola";
    }
    
    @GetMapping(path={"/adios","/hastaluego"})
    public String adios() {
        return "adios";
    }

    @GetMapping(value="/inicio")
    public String inicio(Model model) {
        model.addAttribute("productos", getProductos());
        return "inicio";
    }

    /**
     * @return
     */
    @GetMapping(value="/mapa")
    public String mapa() {
        return "mapa";
    }
    
    @GetMapping(value="/productos")
    public ModelAndView productos(Model model) {
        ModelAndView modelAndView = new ModelAndView(Views.INICIO);
        modelAndView.addObject("productos", getProductos());
        return modelAndView;
    }

    private List<Producto> getProductos(){

        ArrayList<Producto> productos = new ArrayList<Producto>();

        productos.add(new Producto(0, "Cocacola", "Coca-Cola (conocida comúnmente como Coca en muchos países hispanohablantes; en inglés también conocida como Coke) es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios", "/img/cocacola.jpg", null));
        productos.add(new Producto(1, "Pepsi", "Coca-Cola (conocida comúnmente como Coca en muchos países hispanohablantes; en inglés también conocida como Coke) es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios", "/img/pepsi.jpg", null));
        productos.add(new Producto(2, "Fanta", "Coca-Cola (conocida comúnmente como Coca en muchos países hispanohablantes; en inglés también conocida como Coke) es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios", "/img/fanta.jpg", null));
        productos.add(new Producto(3, "Sprite", "Coca-Cola (conocida comúnmente como Coca en muchos países hispanohablantes; en inglés también conocida como Coke) es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios", "/img/sprite.jpg", null));

        return productos;
        
    }

}
