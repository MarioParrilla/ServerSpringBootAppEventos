package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorEditarEvento {
    @GetMapping("/editarEvento")
	public String root() {
		return "editarEvento";
	}
    
    @PostMapping("/editarEvento")
	public String root2() {
		return "editarEvento";
	}
}
