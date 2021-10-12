package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class ControladorEliminarEvento {
    @GetMapping("/eliminarEvento")
	public String root() {
		return "usuarios";
	}
    
    @PostMapping("/eliminarEvento")
	public String root2() {
		return "usuarios";
	}
}
