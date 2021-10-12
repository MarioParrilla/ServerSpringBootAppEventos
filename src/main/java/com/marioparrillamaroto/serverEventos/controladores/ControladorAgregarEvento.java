package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorAgregarEvento {
    @GetMapping("/agregarEvento")
	public String root() {
		return "agregarEvento";
	}
    
    @PostMapping("/agregarEvento")
	public String root2() {
		return "agregarEvento";
	}
}
