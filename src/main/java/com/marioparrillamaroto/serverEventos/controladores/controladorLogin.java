package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controladorLogin {
    @GetMapping("/login")
	public String root() {
		return "login";
	}
}
