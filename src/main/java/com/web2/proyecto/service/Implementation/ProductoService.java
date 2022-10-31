package com.web2.proyecto.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web2.proyecto.converter.ProductoConverter;
import com.web2.proyecto.entities.Producto;
import com.web2.proyecto.model.ProductoModel;
import com.web2.proyecto.repository.IProductoRepository;

import com.web2.proyecto.service.IProductoService;

@Service("productoService")
public class ProductoService implements IProductoService{
	
 	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
 	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	
	
	@Override
	public List<Producto> getAll(){		
		return productoRepository.findAll();	
	}

	public ProductoModel traerPorId(int id) {

		return productoConverter.entityToModel(productoRepository.findById(id));	
	};
	public List<ProductoModel> getAllModel(){
		List<ProductoModel> listaDeProducto = new ArrayList<ProductoModel>();
		for (Producto p:getAll() ) {
			listaDeProducto.add(productoConverter.entityToModel(p));	
		}	
		return listaDeProducto;
	}
	@Override
	public ProductoModel insertOrUpdate(ProductoModel productoModel) {
		Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));	
		return productoConverter.entityToModel(producto);
	}
	@Override
	public boolean remove(int id) {
		try {
			productoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}	
	}
}
