package com.marioparrillamaroto.serverEventos.controladores;

import com.marioparrillamaroto.serverEventos.repository.EventRepository;
import com.marioparrillamaroto.serverEventos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorIndexFull {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EventRepository eventRepository;

    @GetMapping("/menu")
	public String root(Model model) {
		model.addAttribute("estadisticasUsuario", userRepository.count());
		model.addAttribute("estadisticasEvento", eventRepository.count());
		return "index";
	}

	@GetMapping("/cerrarSesion")
	public String cerrarSesion(){
		return "redirect:/login";
	}
}
