package com.web2.proyecto.entities;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity

@Table(name="producto")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="descripcion",nullable=false,length=100)
	private String descripcion;
	
	@Column(name="precio",nullable=false,length=100)
	private float precio;
	
	@Column(name="imagen",nullable=false,length=100)
	private String imagen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Producto() {
		super();
	}

	public Producto(int id, String descripcion, float precio, String imagen) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", imagen=" + imagen
				+ ", compra="+" ]";
	}
	
}
