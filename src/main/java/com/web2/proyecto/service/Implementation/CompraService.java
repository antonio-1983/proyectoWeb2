package com.web2.proyecto.service.Implementation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.web2.proyecto.converter.CompraConverter;
import com.web2.proyecto.entities.Carrito;
import com.web2.proyecto.entities.Compra;
import com.web2.proyecto.entities.Producto;
import com.web2.proyecto.model.CompraModel;
import com.web2.proyecto.repository.ICarritoRepository;
import com.web2.proyecto.repository.ICompraRepository;
import com.web2.proyecto.service.ICompraService;

public class CompraService implements  ICompraService{

	@Autowired
	@Qualifier("compraRepository")
	private ICompraRepository compraRepository;
	
	@Autowired
	@Qualifier("compraConverter")
	private CompraConverter compraConverter;
	
	@Autowired
	@Qualifier("carritoRepository")
	private ICarritoRepository carritoRepository;
	
	
	//**************************IMPLEMENTACIONES**********************************
	@Override
	public List<Compra> getAll(){	
		return compraRepository.findAll();	
	}
	
	public CompraModel traerPorId(int id) {
		return compraConverter.entityToModel(compraRepository.findById(id));
	};
	
	@Override
	public boolean remove(int id) {	
		try {
			compraRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}	
	}
	
	@Override
	public CompraModel insertOrUpdate(CompraModel compraModel) {
		Compra compra = compraRepository.save(compraConverter.modelToEntity(compraModel));		
		return compraConverter.entityToModel(compra);
	}
	
	 public Set<Producto> productoDeLaCompra(int id) {
		Compra p = compraRepository.findByIdAndFetchProductosEagerly(id);
		System.out.println(p);
		Set<Producto> lista = new HashSet<>();
		if (p!=null) {
			if(p.getProductos()!=null) {
				lista = p.getProductos();
			}
		}
		return lista;
	} 
	 
	
	 public CompraModel traerCompraCompletaPorId(int id) {		
			List<Compra> listaEntidad = getComprasCompletas();
			CompraModel compraEncontrada = new CompraModel();
			for (Compra p: listaEntidad) {		
				if(p.getId() == id) {					
					compraEncontrada = compraConverter.entityToModel(p);
				}
			}
			return compraEncontrada;
		}
	 
	 /*******************************************recien agregado***************/
	 
	 public List<Compra> getComprasCompletas(){
			List<Compra> compras = getAll();	
			for (Compra c: compras) {	
				Carrito carrito = carritoRepository.findById(c.getCarrito().getId());	
				Set<Producto> productos = productoDeLaCompra(c.getId());
				if(carrito != null) {
					c.setCarrito(carrito);
				}	
				if(productos!=null) {
				c.setProductos(productos);
				}	
			}	
			return compras;
		}
}
