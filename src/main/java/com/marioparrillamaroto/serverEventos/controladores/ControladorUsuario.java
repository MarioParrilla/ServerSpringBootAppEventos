package com.marioparrillamaroto.serverEventos.controladores;

import com.marioparrillamaroto.serverEventos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorUsuario {

	@Autowired
	private UserRepository userRepository;

    @GetMapping("/usuarios")
	public String root(Model model) {
		model.addAttribute("usuarios", userRepository.findAll());
		return "usuarios";
	}

	@PostMapping("/usuarios")
	public String resolverUsuario() {
		return "usuarios";
	}
    
	@PostMapping("/agregarUsuario")
	public String agregarUsuario() {
		return "agregarUsuario";
	}

	@PostMapping("/editarUsuario")
	public String editarUsuario() {
		return "editarUsuario";
	}

	@PostMapping("/eliminarUsuario")
	public String eliminarUsuario() {
		return "usuarios";
	}
}
