package com.web2.proyecto.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.web2.proyecto.entities.Producto;
import com.web2.proyecto.model.ProductoModel;

@Component("productoConverter")
public class ProductoConverter {
	
	
	 
	 

	public ProductoModel entityToModel(Producto producto) {
		return new ProductoModel(producto.getId(), producto.getDescripcion(),producto.getImagen(),producto.getPrecio());
	}
	
	public Producto modelToEntity(ProductoModel productoModel) {
		return new Producto(productoModel.getId(),productoModel.getDescripcion(),productoModel.getPrecio(),productoModel.getImagen());
	}
	
public Set<ProductoModel> entidadAModeloSet(Set<Producto> productos){		
		Set<ProductoModel>  lista = new HashSet<>();
		for(Producto p: productos) {
			lista.add(entityToModel(p));	
		}
		return lista;
	}

public Set<Producto> modeloAEntidadSet(Set<ProductoModel> productos){	
	Set<Producto>  lista = new HashSet<>();	
	for(ProductoModel p: productos) {		
		lista.add(modelToEntity(p));
	}
	return lista;
}
}
