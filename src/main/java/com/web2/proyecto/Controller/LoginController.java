package com.web2.proyecto.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web2.proyecto.entities.User;
import com.web2.proyecto.repository.UserRepository;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Devuelve la vista de inicio de sesión (login.html)
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userRepository.findByUsername(username);
        
        if (user != null && user.getPassword().equals(password)) {
            // Autenticación exitosa
            return "redirect:/producto/listaProductos"; // Redirige a la página de dashboard
          
        } else {
            // Autenticación fallida
            model.addAttribute("error", "Credenciales inválidas");
            return "/login"; // Devuelve la vista de inicio de sesión con un mensaje de error
        }
    }
}

