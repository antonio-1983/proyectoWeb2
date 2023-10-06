package com.web2.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web2.proyecto.entities.Producto;


@Repository("productoRepository")
public interface IProductoRepository  extends JpaRepository<Producto, Serializable>{

	public abstract Producto findById(int id);
	
	public abstract Producto findByDescripcion(String descripcion);
}
