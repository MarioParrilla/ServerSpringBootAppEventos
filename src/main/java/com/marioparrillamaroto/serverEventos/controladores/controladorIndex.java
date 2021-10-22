package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorIndex {
    @GetMapping("/")
	public String root() {
		return "index";
	}

	@GetMapping("/index")
	public String root2() {
		return "index";
	}

    @GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/resolveLogin")
	public String resolveLogin(){
		return "redirect:/menu";
	}
}
