package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorUsuario {
    @GetMapping("/usuarios")
	public String root() {
		return "usuarios";
	}
    
    @PostMapping("/usuarios")
	public String root2() {
		return "usuarios";
	}
}
