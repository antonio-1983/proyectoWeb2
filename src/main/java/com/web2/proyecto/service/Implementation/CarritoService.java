package com.web2.proyecto.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.web2.proyecto.converter.CarritoConverter;
import com.web2.proyecto.entities.Carrito;

import com.web2.proyecto.model.CarritoModel;
import com.web2.proyecto.repository.ICarritoRepository;
import com.web2.proyecto.service.ICarritoService;

@Service("carritoService")
public class CarritoService implements ICarritoService{
	
	@Autowired
	@Qualifier("carritoRepository")
	private ICarritoRepository carritoRepository;
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;
	
	@Override
	public List<Carrito> getAll(){	
		return carritoRepository.findAll();	
	}
	
	@Override
	public CarritoModel insertOrUpdate(CarritoModel carritoModel) {
		
		Carrito carrito = carritoRepository.save(carritoConverter.modelToEntity(carritoModel));
		
		return carritoConverter.entityToModel(carrito);
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			carritoRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	
}
