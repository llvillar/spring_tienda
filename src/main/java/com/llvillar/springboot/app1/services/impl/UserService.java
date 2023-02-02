package com.llvillar.springboot.app1.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.llvillar.springboot.app1.model.*;
import com.llvillar.springboot.app1.repository.PermisoRepository;
import com.llvillar.springboot.app1.repository.UsuarioRepository;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    UsuarioRepository repo;

    @Autowired
    PermisoRepository repoPerm;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findByName(username);


        Optional<Usuario> findById = repo.findById(user.getCodigo());
        if(findById != null){
            user = findById.get();
        }



        List<GrantedAuthority> roles = new ArrayList<>();

//        List<Permiso> permisos = repoPerm.findByUsuario_codigo(user.getCodigo());

       List<Permiso> permisos = user.getPermisos();

  for(Permiso p : permisos){
    roles.add(new SimpleGrantedAuthority(p.getNombre()));
}
     roles.add(new SimpleGrantedAuthority("ADMIN"));
        
        UserDetails userDetails = new User(user.getName(), user.getPassword(), roles);
        return userDetails;
    }
    
}
