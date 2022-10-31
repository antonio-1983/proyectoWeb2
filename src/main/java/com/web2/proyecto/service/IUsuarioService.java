package com.web2.proyecto.service;

import java.util.List;

import com.web2.proyecto.entities.Usuario;
import com.web2.proyecto.model.UsuarioModel;



public interface IUsuarioService {

	public List<Usuario> getAll();
	
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel);
	
	public boolean remove(int id);
	
	public UsuarioModel traerPorId(int id);
	
	public List<UsuarioModel> getAllModel();
	
}
