package com.llvillar.springboot.app1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llvillar.springboot.app1.model.Proveedor;
import com.llvillar.springboot.app1.services.ProveedoresService;

@Controller
@RequestMapping("/proveedores")
@PreAuthorize("hasAnyAuthority('ADMIN','PROVEEDORES')")
public class ProveedorController {

    @Autowired
    ProveedoresService proveedoresService;

    @Value("${pagination.size}")
    int sizePage;

    @GetMapping(value="/list")
    public ModelAndView list(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:list/1/codigo/asc");
        return modelAndView;
    }

    @GetMapping(value = "/list/{numPage}/{fieldSort}/{directionSort}")
    public ModelAndView listPage(Model model,
            @PathVariable("numPage") Integer numPage,
            @PathVariable("fieldSort") String fieldSort,
            @PathVariable("directionSort") String directionSort) {


        Pageable pageable = PageRequest.of(numPage - 1, sizePage,
            directionSort.equals("asc") ? Sort.by(fieldSort).ascending() : Sort.by(fieldSort).descending());


        Page<Proveedor> page = proveedoresService.findAll(pageable);

        List<Proveedor> proveedores = page.getContent();

        ModelAndView modelAndView = new ModelAndView("proveedores/list");
        modelAndView.addObject("proveedores", proveedores);


		modelAndView.addObject("numPage", numPage);
		modelAndView.addObject("totalPages", 1);
		modelAndView.addObject("totalElements",1);
		modelAndView.addObject("totalPages", page.getTotalPages());
		modelAndView.addObject("totalElements", page.getTotalElements());

		modelAndView.addObject("fieldSort", fieldSort);
		modelAndView.addObject("directionSort", directionSort.equals("asc") ? "asc" : "desc");

        return modelAndView;
    }
    
    @GetMapping(path = { "/edit/{codigo}" })
    public ModelAndView edit(
            @PathVariable(name = "codigo", required = true) int codigo) {

        Proveedor proveedor = proveedoresService.find(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proveedor", proveedor);
        modelAndView.setViewName("proveedores/edit");
        return modelAndView;
    }

    @GetMapping(path = { "/create" })
    public ModelAndView create(Proveedor proveedor) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("proveedor", new Proveedor());
        modelAndView.setViewName("proveedores/new");
        return modelAndView;
    }

    @PostMapping(path = { "/save" })
    public ModelAndView save(Proveedor proveedor) {

        proveedoresService.save(proveedor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + proveedor.getCodigo());
        return modelAndView;
    }

    @PostMapping(path = { "/update" })
    public ModelAndView update(Proveedor proveedor) {

        proveedoresService.update(proveedor);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:edit/" + proveedor.getCodigo());
        return modelAndView;
    }

    @GetMapping(path = { "/delete/{codigo}" })
    public ModelAndView delete(
            @PathVariable(name = "codigo", required = true) int codigo) {

        proveedoresService.delete(codigo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:../list");
        return modelAndView;
    }
}