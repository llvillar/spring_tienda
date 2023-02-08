package com.llvillar.springboot.app1.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.llvillar.springboot.app1.model.Permiso;
import com.llvillar.springboot.app1.model.Usuario;
import java.util.*;

@SpringBootTest
class UsuarioRepositoryTests {

	@Autowired
	UsuarioRepository repo; 
	
	@Autowired
	PermisoRepository repoPer; 

	@Autowired
	PasswordEncoder encoder;

	@Test
	void crearUsuarioTest() {

		Usuario u = new Usuario();
		u.setCodigo("1");
		u.setName("llvillar");
		u.setPassword(encoder.encode("1234"));
		Permiso p = new Permiso(1);
		p.setNombre("ADMIN");
		List<Permiso> permisos = new ArrayList<>();
		permisos.add(p);

		repoPer.save(p);


		
		

		Usuario u2 = new Usuario();
		u2.setCodigo("2");
		u2.setName("llvillar2");
		u2.setPassword(encoder.encode("5555"));
		Permiso p2 = new Permiso(2);
		p2.setNombre("USER");
		List<Permiso> permisos2 = new ArrayList<>();
		permisos2.add(p2);

		repoPer.save(p2);

		u2.setPermisos(permisos2);

		Usuario u2OK = repo.save(u2);

		permisos.add(p2);

		u.setPermisos(permisos);

		Usuario uOK = repo.save(u);

		assertTrue(u.getPassword().equalsIgnoreCase(uOK.getPassword()));
		assertTrue(u2.getPassword().equalsIgnoreCase(u2OK.getPassword()));

	}

}
