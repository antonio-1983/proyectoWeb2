package com.web2.proyecto.service;

import java.util.List;

import com.web2.proyecto.entities.Producto;
import com.web2.proyecto.model.ProductoModel;

public interface IProductoService {
	
	public List<Producto> getAll();
	
	public ProductoModel insertOrUpdate(ProductoModel productoModel);
	
	public boolean remove(int id);
	
	public ProductoModel traerPorId(int id);
	
	public List<ProductoModel> getAllModel();
}
