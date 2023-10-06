package com.web2.proyecto.Controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web2.proyecto.Helpers.ViewRouteHelper;
import com.web2.proyecto.model.ProductoModel;
import com.web2.proyecto.model.UsuarioModel;
import com.web2.proyecto.service.ICarritoService;

import com.web2.proyecto.service.IProductoService;



import com.web2.proyecto.service.IUsuarioService;

@Controller
//@RequestMapping("/home")
public class Controllers {
	
	@Autowired
	@Qualifier("usuarioService")
	private IUsuarioService usuarioService;

	
	@Autowired
	@Qualifier("carritoService")
	private ICarritoService carritoService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	
		@GetMapping ("")
		public ModelAndView inicio() {
			return listaProducto();
		}
		
		
		@GetMapping ("/index")
		public ModelAndView  listaProducto() {	
			ModelAndView mV = new ModelAndView();
			mV.setViewName(ViewRouteHelper.INDEX);
			mV.addObject("listaProductos",productoService.getAll());
			return mV;	
		}
		

		@GetMapping ("/formularioUsuario")
		public ModelAndView formularioUsuario(Model model) {
			model.addAttribute("usuario", new UsuarioModel());
			ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.FORM_USUARIO);
			return modelAndView;
		}
	
		//creado recien***************************
		
		@PostMapping("/nuevoUsuario")
		public ModelAndView nuevoUsuario(@Valid @ModelAttribute("usuario")UsuarioModel usuario, BindingResult b) {
			ModelAndView mV = new ModelAndView();
			if (b.hasErrors()) {
				mV.setViewName(ViewRouteHelper.FORM_USUARIO);
			}
				else {
					usuarioService.insertOrUpdate(usuario);
					mV.setViewName(ViewRouteHelper.NUEVO_USUARIO);
					mV.addObject("usuario", usuario);
					mV.addObject("listaProductos",productoService.getAll());
					//mV.addObject("listaUsuarios",usuarioService.getAll());
				}
			return mV;
		}
		
		
		
		
		
		
		/*AGREGANDO EL CONTROLLER QUE ME LLEVE A LA LISTA DE CONSULTAS
		 */
		  @GetMapping("/listaConsultas")
			public ModelAndView listaConsultas() {
			ModelAndView mV = new ModelAndView();
			mV.setViewName(ViewRouteHelper.LISTA_CONSULTAS);
			mV.addObject("listaConsultas",usuarioService.getAll());
			return mV;
		}
		  
		  
		  //********agregando mas controllers 08/09/2023************
		  
		  
		  @GetMapping("/editarConsulta/{id}")
			public ModelAndView editarConsulta(@PathVariable("id") int id, Model model) {
				UsuarioModel usuario = usuarioService.traerPorId(id);
				model.addAttribute("usuario", usuario);
				ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.FORM_CONSULTAS);
				return modelAndView;
			}
		  
		  
		  
		  //HASTA EL FORMULARIO DE NUEVA RESPUESTA, CUANDO TOCO EL BOTON DE EDITAR NO ME ANDA ERROR 405
		  
		  
		  
		  @PostMapping("/editarConsulta/nuevaRespuesta") 
			public ModelAndView editarConsulta(@Valid @ModelAttribute("usuario")UsuarioModel usuario, BindingResult b) {
				ModelAndView mV = new ModelAndView();
				 if (b.hasErrors()) {
				mV.setViewName(ViewRouteHelper.FORM_CONSULTAS);
			}
				else {
					usuarioService.insertOrUpdate(usuario);
					mV.setViewName(ViewRouteHelper.LISTA_CONSULTAS);//probando este redirect
					mV.addObject("usuario", usuario);
					
					mV.addObject("listaConsultas",usuarioService.getAll());
				}
			return mV;
		  }
		  
		  @PostMapping("/nuevaRespuesta") 
			public ModelAndView nuevaRespuesta(@Valid @ModelAttribute("usuario")UsuarioModel usuario, BindingResult b) {
				ModelAndView mV = new ModelAndView();
				 if (b.hasErrors()) {
				mV.setViewName(ViewRouteHelper.FORM_CONSULTAS);
			}
				else {
					usuarioService.insertOrUpdate(usuario);
					mV.setViewName(ViewRouteHelper.LISTA_CONSULTAS);//probando este redirect
					mV.addObject("usuario", usuario);
					
					mV.addObject("listaConsultas",usuarioService.getAll());
				}
			return mV;
		  }
		  
		  
			@GetMapping ("/formConsultas")
			public ModelAndView formConsultas(Model model) {
				model.addAttribute("usuario", new UsuarioModel());
				ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.FORM_CONSULTAS);
				return modelAndView;
			}
	}
