package com.llvillar.springboot.app1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {

    @Id
    private String codigo;
    private String name;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="usuario_permiso"
		, joinColumns={
			@JoinColumn(name="usuario_codigo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="permiso_id")
			}
		)
    private List<Permiso> permisos;
    
    
    public Usuario() {
    }
    public Usuario(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }
    public List<Permiso> getPermisos() {
        return permisos;
    }
    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }

    
    
}
