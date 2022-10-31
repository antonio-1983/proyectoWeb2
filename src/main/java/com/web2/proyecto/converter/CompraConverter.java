package com.web2.proyecto.converter;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import com.web2.proyecto.entities.Compra;

import com.web2.proyecto.model.CompraModel;

@Component("compraConverter")
public class CompraConverter {
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;
	
	public CompraModel entityToModel(Compra compra) {
		return new CompraModel(compra.getId(),carritoConverter.entityToModel(compra.getCarrito()));
	}
	public Compra modelToEntity(CompraModel compraModel) {
		return new Compra(compraModel.getId(),carritoConverter.modelToEntity(compraModel.getCarrito()));
	}
}

