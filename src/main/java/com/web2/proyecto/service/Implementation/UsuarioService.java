package com.web2.proyecto.service.Implementation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.web2.proyecto.converter.UsuarioConverter;
import com.web2.proyecto.entities.Usuario;
import com.web2.proyecto.model.UsuarioModel;
import com.web2.proyecto.repository.ICarritoRepository;
import com.web2.proyecto.repository.IUsuarioRepository;
import com.web2.proyecto.service.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService{

	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	@Autowired
	@Qualifier("carritoRepository")
	private ICarritoRepository carritoRepository;
	
	@Override
	public List<Usuario> getAll(){	
		return usuarioRepository.findAll();	
	}
	
	public UsuarioModel traerPorId(int id) {
		return usuarioConverter.entityToModel(usuarioRepository.findById(id));
	};
	
	public List<UsuarioModel> getAllModel(){
		List<UsuarioModel> listaDeUsuario = new ArrayList<UsuarioModel>();
		for (Usuario u:getAll() ) {
			listaDeUsuario.add(usuarioConverter.entityToModel(u));
		}
		return listaDeUsuario;
	}

	@Override
	public UsuarioModel insertOrUpdate(UsuarioModel usuarioModel) {
		Usuario usuario = usuarioRepository.save(usuarioConverter.modelToEntity(usuarioModel));	
		return usuarioConverter.entityToModel(usuario);
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			usuarioRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
}
