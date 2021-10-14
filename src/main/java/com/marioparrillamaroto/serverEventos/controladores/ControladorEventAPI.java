package com.marioparrillamaroto.serverEventos.controladores;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marioparrillamaroto.serverEventos.entity.Evento;
import com.marioparrillamaroto.serverEventos.repository.EventRepository;

@RestController
@RequestMapping("/api/")
public class ControladorEventAPI {
	
	@Autowired
	private EventRepository eventRepository;
	
	//Buscar Eventos
	@GetMapping("/evento")
	public ArrayList<Evento> getEventos(){
		return (ArrayList<Evento>) eventRepository.findAll();
	}
	
	//Buscar Evento
	@GetMapping("/evento/{eventID}")
	public Evento getEvento(@PathVariable("eventID") Long eventID){
		return eventRepository.findById(eventID).orElse(null);
	}
	
	//Guardar Evento
	@PostMapping("/evento")
	public String guardarEvento(@RequestBody Evento event) {
		eventRepository.save(event);
		return "evento";
	}
	
	//Borrar Evento
	@DeleteMapping("/evento/{eventID}")
	public String EliminarEvento(@PathVariable("eventID") Long eventID){
		eventRepository.deleteById(eventID);
		return "evento";
	}
	
	//Modificar Evento
	@PutMapping("/evento/{eventID}")
	public String modificarUsuario(@RequestBody Evento event) {
		eventRepository.save(event);
		return "evento";
	}
}
