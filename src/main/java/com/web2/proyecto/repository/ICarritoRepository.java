package com.web2.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web2.proyecto.entities.Carrito;


@Repository("carritoRepository")
public interface ICarritoRepository extends 
					JpaRepository<Carrito, Serializable> {
	
	public abstract Carrito findById(int id);

}
