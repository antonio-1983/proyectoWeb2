package com.web2.proyecto.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.web2.proyecto.entities.Usuario;
import com.web2.proyecto.model.UsuarioModel;



@Component("usuarioConverter")
public class UsuarioConverter {
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;

	public UsuarioModel entityToModel(Usuario usuario) {
		return new UsuarioModel(usuario.getId(), usuario.getNombre(),usuario.getApellido(),usuario.getEmail(),usuario.getConsulta(),usuario.getRespuesta(), carritoConverter.entityToModel(usuario.getCarrito()));
	}
	
public Usuario modelToEntity(UsuarioModel usuarioModel) {		
		return new Usuario(usuarioModel.getId(), usuarioModel.getNombre(),usuarioModel.getApellido() ,usuarioModel.getEmail(),usuarioModel.getConsulta(),usuarioModel.getRespuesta(), carritoConverter.modelToEntity(usuarioModel.getCarrito()));
	}
}
