package com.llvillar.springboot.app1.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llvillar.springboot.app1.model.Pedido;
import com.llvillar.springboot.app1.services.PedidosService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidosService pedidosService;

    @Value("${pagination.size}")
    int sizePage;


    @GetMapping(value = "/list")
    public ModelAndView list(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/desc");
        return modelAndView;
    }
  
    @GetMapping(value = "/list/{numPage}/{fieldSort}/{directionSort}")
    public ModelAndView listPage(Model model,
            @PathVariable("numPage") Integer numPage,
            @PathVariable("fieldSort") String fieldSort,
            @PathVariable("directionSort") String directionSort) {


        Pageable pageable = PageRequest.of(numPage - 1, sizePage,
            directionSort.equals("asc") ? Sort.by(fieldSort).ascending() : Sort.by(fieldSort).descending());

        Page<Pedido> page = pedidosService.findAll(pageable);

        List<Pedido> pedidos = page.getContent();

        ModelAndView modelAndView = new ModelAndView("pedidos/list");
        modelAndView.addObject("pedidos", pedidos);


		modelAndView.addObject("numPage", numPage);
		modelAndView.addObject("totalPages", page.getTotalPages());
		modelAndView.addObject("totalElements", page.getTotalElements());

		modelAndView.addObject("fieldSort", fieldSort);
		modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    }

    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo, final Locale locale) {

        Pedido pedido = pedidosService.find(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pedido", pedido);

        modelAndView.setViewName("pedidos/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/save" })
    public ModelAndView save(HttpSession session)
            throws IOException {

        Pedido pedido = (Pedido) session.getAttribute("pedido");

        pedidosService.save(pedido);

        session.removeAttribute("pedido");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list");

        return modelAndView;
    }
}