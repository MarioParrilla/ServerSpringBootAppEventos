package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorError {
    @GetMapping("/Error")
	public String root() {
		return "error";
	}
}
