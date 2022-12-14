package com.web2.proyecto.Controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.web2.proyecto.Helpers.ViewRouteHelper;

import com.web2.proyecto.model.CompraModel;
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
		
		
		
	//*********************************************************
		
		@GetMapping ("/carrito")
		public ModelAndView carrito(Model model) {
			model.addAttribute("compra", new CompraModel());
			ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.CARRITO);
			return modelAndView;
	
		}

		//**********************TRATANDO DE HACER EL CARRITO /\ ***********
		
		
		
		
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
		
		/*
		  @GetMapping("/agregarCarrito/{id}")
		  public ModelAndView (@PathVariable("id") int id, Model model) {
		  ModelAndView mV = new ModelAndView();
		  compraService.insertOrUpdate(compra);
		  return mV;	
		  }
		 */
	}
