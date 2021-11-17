package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controladorIndex {
    @GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String resolveLogin(){
		return "redirect:/";
	}
}
