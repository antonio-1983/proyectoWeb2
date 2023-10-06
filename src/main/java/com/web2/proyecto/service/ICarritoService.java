package com.web2.proyecto.service;

import java.util.List;

import com.web2.proyecto.entities.Carrito;
import com.web2.proyecto.model.CarritoModel;


public interface ICarritoService {

	
	public List<Carrito> getAll();
	
	public CarritoModel insertOrUpdate(CarritoModel carritoModel);
	
	
	
	public boolean remove(int id);
	

	
}
