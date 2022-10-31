package com.web2.proyecto.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class Compra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="carrito_id")
	private Carrito carrito;
	
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	})
	@JoinTable(name = "compra_producto",
	joinColumns = @JoinColumn(name="compra_id"),
	inverseJoinColumns = @JoinColumn(name="producto_id")
	)
	private Set<Producto> productos = new HashSet<>();
	
	public Compra(int id, Carrito carrito) {
		super();
		this.id = id;
		this.carrito = carrito;
	}

	public Compra(int id, Carrito carrito, Set<Producto> productos) {
		super();
		this.id = id;
		this.carrito = carrito;
		this.productos = productos;
	}

	public Compra() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	
	
}
