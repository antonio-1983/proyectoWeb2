package com.web2.proyecto.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="email")
	private String email;
	
	@Column(name="consulta")
	private String consulta;
	
	@Column(name="respuesta")
	private String respuesta;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "carrito_id",referencedColumnName="id")
	private Carrito carrito;

	public Usuario(int id, String nombre, String apellido, String email, Carrito carrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.carrito = carrito;
	}

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String email, Carrito carrito) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.carrito = carrito;
	}
	
	

	public Usuario(int id, String nombre, String apellido, String email, String consulta, Carrito carrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.consulta = consulta;
		this.carrito = carrito;
	}
	
	

	public Usuario(int id, String nombre, String apellido, String email, String consulta, String respuesta,
			Carrito carrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.consulta = consulta;
		this.respuesta = respuesta;
		this.carrito = carrito;
	}

	
	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
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

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
