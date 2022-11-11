package com.llvillar.springboot.app1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llvillar.springboot.app1.model.Usuario;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = {"/signin"})
    public String signin(){
        return "signin";
    }

    @PostMapping(value = "/login")
    public String login(Model model, Usuario usuario){


        String greetings = messageSource.getMessage("saludar.usuario",new String[]{usuario.getName()}, LocaleContextHolder.getLocale());

//        model.addAttribute("greetings", "¡Bienvenido, " + usuario.getName() + "!");
        model.addAttribute("greetings", greetings);
        return "welcome";
    }

    @GetMapping(value = {"/logout"})
    public String logout(){
        return "signin";
    }

    @GetMapping(value = {"/welcome"})
    public String welcome(){
        return "welcome";
    }
}
