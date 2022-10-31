package com.web2.proyecto.model;

import java.util.HashSet;
import java.util.Set;

public class CompraModel {

	private int id;

	private CarritoModel carrito;
	

	private Set<ProductoModel> productos = new HashSet<>();
	
	public Set<ProductoModel> getProductos() {
		return productos;
	}



	public void setProductos(Set<ProductoModel> productos) {
		this.productos = productos;
	}



	public CompraModel(int id, CarritoModel carrito) {
		super();
		this.id = id;
		this.carrito = carrito;
	}
	
	

	public CompraModel(int id) {
		super();
		this.id = id;
	}



	public CompraModel() {
		super();
	}

	
	
	public CompraModel(int id, CarritoModel carrito, Set<ProductoModel> productos) {
		super();
		this.id = id;
		this.carrito = carrito;
		this.productos = productos;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CarritoModel getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoModel carrito) {
		this.carrito = carrito;
	}
	
		
	
}
