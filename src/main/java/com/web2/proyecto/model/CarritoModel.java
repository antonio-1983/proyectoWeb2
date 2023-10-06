package com.web2.proyecto.model;


public class CarritoModel {

	private int id;

	private UsuarioModel usuario;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	public CarritoModel() {
		super();
	}

	public CarritoModel(int id, UsuarioModel usuario) {
		super();
		this.id = id;
		this.usuario = usuario;
	}

	public CarritoModel(int id) {
		super();
		this.id = id;
	}

	
	
	
	
}
