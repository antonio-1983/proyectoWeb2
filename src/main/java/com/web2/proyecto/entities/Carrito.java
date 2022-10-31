package com.web2.proyecto.entities;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="carrito")
public class Carrito {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="creado")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	//Relacion no propietaria
	@OneToOne(mappedBy = "carrito")
	private Usuario usuario;

	@OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Compra> compras;
	
	

	public Carrito() {
		super();
	}

	public Carrito(int id, LocalDateTime createdAt, Usuario usuario) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.usuario = usuario;
	}

	public Carrito(LocalDateTime createdAt, Usuario usuario) {
		super();
		this.createdAt = createdAt;
		this.usuario = usuario;
	}
	
	

	public Carrito(int id) {
		super();
		this.id = id;
	}

	public Carrito(int id, Usuario usuario) {
		super();
		this.id = id;
		this.usuario = usuario;
	}
	
	

	public Carrito(int id, LocalDateTime createdAt, Usuario usuario, List<Compra> compras) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.usuario = usuario;
		this.compras = compras;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

}
