package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorIndexFull {
    @GetMapping("/menu")
	public String root() {
		return "menu";
	}

	@GetMapping("/cerrarSesion")
	public String cerrarSesion(){
		return "redirect:/";
	}
}
