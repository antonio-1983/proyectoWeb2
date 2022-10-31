package com.web2.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.web2.proyecto.entities.Compra;

@Repository("compraRepository")
public interface ICompraRepository extends JpaRepository<Compra, Serializable>{

	public abstract Compra findById(int id);
	
	 	@Query("SELECT p FROM Compra p JOIN FETCH p.productos WHERE p.id = (:id)")
	public abstract Compra findByIdAndFetchProductosEagerly(@Param("id") int id);
	 
}
