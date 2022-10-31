package com.web2.proyecto.converter;

import org.springframework.stereotype.Component;

import com.web2.proyecto.entities.Carrito;
import com.web2.proyecto.model.CarritoModel;

@Component("carritoConverter")
public class CarritoConverter {
	public CarritoModel entityToModel(Carrito carrito) {		
		return new CarritoModel(carrito.getId());
	}
	public Carrito modelToEntity(CarritoModel carritoModel) {
		return new Carrito(carritoModel.getId());
	}
}
