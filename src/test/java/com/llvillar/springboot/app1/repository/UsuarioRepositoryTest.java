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

		Usuario u1 = new Usuario();
		u1.setCodigo("1");
		u1.setName("usuario1");
		u1.setPassword(encoder.encode("1234"));

		Usuario u2 = new Usuario();
		u2.setCodigo("2");
		u2.setName("usuario2");
		u2.setPassword(encoder.encode("1234"));


		Usuario u3 = new Usuario();
		u3.setCodigo("3");
		u3.setName("usuario3");
		u3.setPassword(encoder.encode("1234"));

		Usuario u4 = new Usuario();
		u4.setCodigo("4");
		u4.setName("usuario4");
		u4.setPassword(encoder.encode("1234"));

		Permiso p_admin = new Permiso(1);
		p_admin.setNombre("ADMIN");

		repoPer.save(p_admin);

		Permiso p_user = new Permiso(2);
		p_user.setNombre("USER");

		repoPer.save(p_user);

		Permiso p_clientes = new Permiso(3);
		p_clientes.setNombre("CLIENTES");

		repoPer.save(p_clientes);

		Permiso p_productos = new Permiso(4);
		p_productos.setNombre("PRODUCTOS");

		repoPer.save(p_productos);

		Permiso p_PEDIDOS = new Permiso(5);
		p_PEDIDOS.setNombre("PEDIDOS");

		repoPer.save(p_PEDIDOS);

		Permiso P_PROEVEEDORES = new Permiso(6);
		P_PROEVEEDORES.setNombre("PROVEEDORES");

		repoPer.save(P_PROEVEEDORES);

		Permiso p_EMPLEADOS = new Permiso(7);
		p_EMPLEADOS.setNombre("EMPLEADOS");

		repoPer.save(p_EMPLEADOS);

		Permiso p_DEPARTAMENTOS = new Permiso(8);
		p_DEPARTAMENTOS.setNombre("DEPARTAMENTOS");

		repoPer.save(p_DEPARTAMENTOS);

		Permiso p_CESTA = new Permiso(4);
		p_CESTA.setNombre("CESTA");

		repoPer.save(p_CESTA);



		List<Permiso> permisosUsaurio1 = new ArrayList<Permiso>();
		permisosUsaurio1.add(p_admin);

		u1.setPermisos(permisosUsaurio1);


		List<Permiso> permisosUsaurio2 = new ArrayList<Permiso>();
		permisosUsaurio2.add(p_PEDIDOS);

		u2.setPermisos(permisosUsaurio2);

		List<Permiso> permisosUsaurio3 = new ArrayList<Permiso>();
		permisosUsaurio3.add(p_clientes);
		permisosUsaurio3.add(p_PEDIDOS);

		u3.setPermisos(permisosUsaurio3);

		List<Permiso> permisosUsaurio4 = new ArrayList<Permiso>();
		permisosUsaurio4.add(p_user);

		u4.setPermisos(permisosUsaurio4);

		Usuario u1OK = repo.save(u1);
		repo.save(u2);
		repo.save(u3);
		repo.save(u4);

		assertTrue(u1.getPassword().equalsIgnoreCase(u1OK.getPassword()));
	}

}
