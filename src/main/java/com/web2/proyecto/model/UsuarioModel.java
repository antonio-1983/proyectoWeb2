package com.web2.proyecto.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class UsuarioModel {

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", carrito=" + carrito + "]";
	}

	private int id;
	
	@Size(min=4, max=12)	
	private String nombre;

	@Size(min=4, max =12)
	private String apellido;
	
	@Email
	@Size(min=10,max=30)
	private String email;
	
	@Size(min=4, max =100)
	private String consulta;
	
	@Size(min=4, max =100)
	private String respuesta;
	
	private CarritoModel carrito;
	
	

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CarritoModel getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoModel carrito) {
		this.carrito = carrito;
	}

	public UsuarioModel()
	{}

	public UsuarioModel(int id, @Size(min = 4, max = 12) String nombre, @Size(min = 4, max = 12) String apellido,
			@Email @Size(min = 10, max = 20) String email, CarritoModel carrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.carrito = carrito;
	}

	public UsuarioModel(@Size(min = 4, max = 12) String nombre, @Size(min = 4, max = 12) String apellido,
			@Email @Size(min = 10, max = 20) String email, CarritoModel carrito) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.carrito = carrito;
	}

	public UsuarioModel(int id, @Size(min = 4, max = 12) String nombre, @Size(min = 4, max = 12) String apellido,
			@Email @Size(min = 10, max = 20) String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public UsuarioModel(@Size(min = 4, max = 12) String nombre, @Size(min = 4, max = 12) String apellido,
			@Email @Size(min = 10, max = 20) String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public UsuarioModel(int id, @Size(min = 4, max = 12) String nombre, @Size(min = 4, max = 12) String apellido,
			@Email @Size(min = 10, max = 30) String email, @Size(min = 4, max = 100) String consulta,
			CarritoModel carrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.consulta = consulta;
		this.carrito = carrito;
	}

	public UsuarioModel(int id, @Size(min = 4, max = 12) String nombre, @Size(min = 4, max = 12) String apellido,
			@Email @Size(min = 10, max = 30) String email, @Size(min = 4, max = 100) String consulta,
			@Size(min = 4, max = 100) String respuesta, CarritoModel carrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.consulta = consulta;
		this.respuesta = respuesta;
		this.carrito = carrito;
	}

	

}
