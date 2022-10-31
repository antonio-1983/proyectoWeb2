package com.web2.proyecto.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.validation.Valid;
import java.nio.file.Path;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web2.proyecto.Helpers.ViewRouteHelper;
import com.web2.proyecto.model.ProductoModel;

import com.web2.proyecto.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class productoController {
//********************COMPLETANDO LOS CONTROLLERS****CAMBIANDO POR EL FORM PRODUCTO************************
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService; 
	 	
	@GetMapping ("/formProducto")
	public ModelAndView formProducto(Model model) {
		model.addAttribute("producto", new ProductoModel());
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.FORM_PRODUCTO);
		return modelAndView;
	}

	
	@PostMapping("/nuevoProducto")
	public ModelAndView nuevoProducto(@Valid @ModelAttribute("producto")ProductoModel producto,
			BindingResult b, @RequestParam("file") MultipartFile imagen) {
		ModelAndView mV = new ModelAndView();
		if (b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.FORM_PRODUCTO);
		}
			else {
				if(!imagen.isEmpty()) {
					Path directorioImagenes = Paths.get("src//main//resources//static/fotos");
					String rutaAbsoluta=directorioImagenes.toFile().getAbsolutePath();
					try {
						byte[] bytesImg=imagen.getBytes();
						Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
						Files.write(rutaCompleta, bytesImg);
						
						producto.setImagen(imagen.getOriginalFilename());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				productoService.insertOrUpdate(producto);
				mV.setViewName(ViewRouteHelper.NUEVO_PRODUCTO);
				mV.addObject("producto", producto);
				mV.addObject("listaProductos",productoService.getAll());
			}
		return mV;
	}

	//creado recien********SEGUIR CREANDO LOS CONTROLLERS
}
