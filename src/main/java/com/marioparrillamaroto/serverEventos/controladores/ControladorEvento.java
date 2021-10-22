package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorEvento {
    @GetMapping("/eventos")
	public String root() {
		return "eventos";
	}
	
	@PostMapping("/eventos")
	public String resolverEvento() {
		return "eventos";
	}

	@PostMapping("/agregarEvento")
	public String agregarEvento() {
		return "agregarEvento";
	}

	@PostMapping("/editarEvento")
	public String editarEvento() {
		return "editarEvento";
	}

	@PostMapping("/eliminarEvento")
	public String eliminarEvento() {
		return "usuarios";
	}
}
