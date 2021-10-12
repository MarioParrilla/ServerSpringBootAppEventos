package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorAgregarUsuario {
    @GetMapping("/agregarUsuario")
	public String root() {
		return "agregarUsuario";
	}
    
    @PostMapping("/agregarUsuario")
	public String root2() {
		return "agregarUsuario";
	}
}
