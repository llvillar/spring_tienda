package com.llvillar.springboot.app1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.llvillar.springboot.app1.model.Producto;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {
        ModelAndView modelAndView = new ModelAndView("productos/list");
        modelAndView.addObject("productos", getProductos());
        modelAndView.addObject("title", "Productos");
        return modelAndView;
    }

    @GetMapping(path = { "/edit" })
    public ModelAndView edit(
            @RequestParam(name = "codigo", required = true) int codigo) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("producto", getProducto(codigo));
        modelAndView.setViewName("productos/edit");
        return modelAndView;
    }

    private Producto getProducto(int codigo){
        List<Producto> productos = getProductos();
        int indexOf = productos.indexOf(new Producto(codigo));

        return productos.get(indexOf);

    }

    private List<Producto> getProductos() {

        ArrayList<Producto> productos = new ArrayList<Producto>();

        productos.add(new Producto(0, "Cocacola",
                "Coca-Cola (conocida comúnmente como Coca en muchos países hispanohablantes; en inglés también conocida como Coke) es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios",
                "/img/cocacola.jpg", null));
        productos.add(new Producto(1, "Pepsi",
                "Coca-Cola (conocida comúnmente como Coca en muchos países hispanohablantes; en inglés también conocida como Coke) es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios",
                "/img/pepsi.jpg", null));
        productos.add(new Producto(2, "Fanta",
                "Coca-Cola (conocida comúnmente como Coca en muchos países hispanohablantes; en inglés también conocida como Coke) es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios",
                "/img/fanta.jpg", null));
        productos.add(new Producto(3, "Sprite",
                "Coca-Cola (conocida comúnmente como Coca en muchos países hispanohablantes; en inglés también conocida como Coke) es una bebida azucarada gaseosa vendida a nivel mundial en tiendas, restaurantes y máquinas expendedoras en más de doscientos países o territorios",
                "/img/sprite.jpg", null));

        return productos;

    }

}
