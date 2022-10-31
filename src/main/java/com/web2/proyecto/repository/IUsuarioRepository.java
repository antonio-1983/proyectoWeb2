package com.web2.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web2.proyecto.entities.Usuario;


@Repository("usuarioRepository")//capa para interactuar con la bbdd  -- se llama desde service
public interface IUsuarioRepository extends JpaRepository<Usuario, Serializable> {
	
	public abstract Usuario findById(int id);
	
	public abstract Usuario findByNombre(String nombre);
	
    
}
