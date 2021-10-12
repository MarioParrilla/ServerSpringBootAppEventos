package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorEditarUsuario {
    @GetMapping("/editarUsuario")
	public String root() {
		return "editarrUsuario";
	}
    
    @PostMapping("/editarUsuario")
	public String root2() {
		return "editarUsuario";
	}
}
