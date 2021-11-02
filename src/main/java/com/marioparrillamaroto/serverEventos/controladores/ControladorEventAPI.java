package com.marioparrillamaroto.serverEventos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Evento> getEventos(){
		return new ResponseEntity( eventRepository.findAll(), HttpStatus.OK);
	}
	
	//Buscar Evento
	@GetMapping("/evento/{eventID}")
	public ResponseEntity<Evento> getEvento(@PathVariable("eventID") Long eventID){
		return new ResponseEntity(eventRepository.findById(eventID).orElse(null),HttpStatus.OK);
	}
	
	//Guardar Evento
	@PostMapping("/evento")
	public ResponseEntity<Evento> guardarEvento(@RequestBody Evento event) {
		eventRepository.save(event);
		return new ResponseEntity(eventRepository.findById(event.getEventID()).orElse(null),HttpStatus.OK);
	}
	
	//Borrar Evento
	@DeleteMapping("/evento/{eventID}")
	public ResponseEntity<Evento> EliminarEvento(@PathVariable("eventID") Long eventID){
		eventRepository.deleteById(eventID);
		return new ResponseEntity(null, HttpStatus.OK);
	}
	
	//Modificar Evento
	@PutMapping("/evento/{eventID}")
	public ResponseEntity<Evento> modificarUsuario(@RequestBody Evento event) {
		eventRepository.save(event);
		return new ResponseEntity(eventRepository.findById(event.getEventID()).orElse(null),HttpStatus.OK);
	}
}
