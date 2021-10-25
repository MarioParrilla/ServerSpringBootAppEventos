package com.marioparrillamaroto.serverEventos.controladores;

import com.marioparrillamaroto.serverEventos.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorEvento {

	@Autowired
	private EventRepository eventRepository;

    @GetMapping("/eventos")
	public String root(Model model) {
		model.addAttribute("eventos", eventRepository.findAll());
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
