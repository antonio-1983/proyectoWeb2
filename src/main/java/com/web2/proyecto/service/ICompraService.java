package com.web2.proyecto.service;

import java.util.List;
import java.util.Set;

import com.web2.proyecto.entities.Compra;
import com.web2.proyecto.entities.Producto;
import com.web2.proyecto.model.CompraModel;

public interface ICompraService {

	public List<Compra> getAll();
	
	public CompraModel insertOrUpdate(CompraModel compraModel);
	
	public boolean remove(int id);
	
	public Set<Producto> productoDeLaCompra(int id);
	
	public CompraModel traerCompraCompletaPorId(int id);
	
	public List<Compra> getComprasCompletas();
	
}
