package com.marioparrillamaroto.serverEventos.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorIndex {
    @GetMapping("/login")
	public String login(HttpSession session) {
		return "login";
	}

	@PostMapping("/login")
	public String resolveLogin(){
		return "redirect:/";
	}
}
