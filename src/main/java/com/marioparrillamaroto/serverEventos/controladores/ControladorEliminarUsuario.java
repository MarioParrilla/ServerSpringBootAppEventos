package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class ControladorEliminarUsuario {
    @GetMapping("/eliminarUsuario")
	public String root() {
		return "usuarios";
	}
    
    @PostMapping("/eliminarUsuario")
	public String root2() {
		return "usuarios";
	}
}
