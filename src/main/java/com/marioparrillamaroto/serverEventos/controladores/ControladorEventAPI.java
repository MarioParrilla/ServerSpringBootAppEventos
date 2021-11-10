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

import javax.servlet.http.HttpServletRequest;

import com.marioparrillamaroto.serverEventos.entity.Evento;
import com.marioparrillamaroto.serverEventos.repository.EventRepository;
import com.marioparrillamaroto.serverEventos.services.JWTService;

@RestController
@RequestMapping("/api/")
public class ControladorEventAPI {
	
	@Autowired
	private JWTService jwtService;

	@Autowired
	private EventRepository eventRepository;

	//Buscar Eventos
	@GetMapping("/evento")
	public ResponseEntity<Evento> getEventos(HttpServletRequest request){

		try {
			String token = request.getHeader("Authorization");  
			if (token!=null) {
				if (jwtService.validateToken(request)){
					return new ResponseEntity( eventRepository.findAll(), HttpStatus.OK);
				}else{
					throw new Exception("Acceso denegado, no tiene un tiempo de permiso valido");
				}
			} else {
				throw new Exception("Acceso denegado, no tienes permiso");
			}
		} catch (Exception e) {
			return new ResponseEntity( e.getMessage(), HttpStatus.FORBIDDEN);
		}
	}
	
	//Buscar Evento
	@GetMapping("/evento/{eventID}")
	public ResponseEntity<Evento> getEvento(@PathVariable("eventID") Long eventID, HttpServletRequest request){
		try {
			String token = request.getHeader("Authorization");  
			if (token!=null) {
				if (jwtService.validateToken(request)){
					return new ResponseEntity(eventRepository.findById(eventID).orElse(null),HttpStatus.OK);
				}else{
					throw new Exception("Acceso denegado, no tiene un tiempo de permiso valido");
				}
			} else {
				throw new Exception("Acceso denegado, no tienes permiso");
			}
		} catch (Exception e) {
			return new ResponseEntity( e.getMessage(), HttpStatus.FORBIDDEN);
		}
	}
	
	//Guardar Evento
	@PostMapping("/evento")
	public ResponseEntity<Evento> guardarEvento(@RequestBody Evento event, HttpServletRequest request) {
		try {
			String token = request.getHeader("Authorization");  
			if (token!=null) {
				if (jwtService.validateToken(request)){
					eventRepository.save(event);
					return new ResponseEntity(eventRepository.findById(event.getEventID()).orElse(null),HttpStatus.OK);
				}else{
					throw new Exception("Acceso denegado, no tiene un tiempo de permiso valido");
				}
			} else {
				throw new Exception("Acceso denegado, no tienes permiso");
			}
		} catch (Exception e) {
			return new ResponseEntity( e.getMessage(), HttpStatus.FORBIDDEN);
		}
	}
	
	//Borrar Evento
	@DeleteMapping("/evento/{eventID}")
	public ResponseEntity<Evento> EliminarEvento(@PathVariable("eventID") Long eventID, HttpServletRequest request){
		try {
			String token = request.getHeader("Authorization");  
			if (token!=null) {
				if (jwtService.validateToken(request)){
					eventRepository.deleteById(eventID);
					return new ResponseEntity(null, HttpStatus.OK);
				}else{
					throw new Exception("Acceso denegado, no tiene un tiempo de permiso valido");
				}
			} else {
				throw new Exception("Acceso denegado, no tienes permiso");
			}
		} catch (Exception e) {
			return new ResponseEntity( e.getMessage(), HttpStatus.FORBIDDEN);
		}
	}
	
	//Modificar Evento
	@PutMapping("/evento/{eventID}")
	public ResponseEntity<Evento> modificarUsuario(@RequestBody Evento event, HttpServletRequest request) {
		try {
			String token = request.getHeader("Authorization");  
			if (token!=null) {
				if (jwtService.validateToken(request)){
					eventRepository.save(event);
					return new ResponseEntity(eventRepository.findById(event.getEventID()).orElse(null),HttpStatus.OK);
				}else{
					throw new Exception("Acceso denegado, no tiene un tiempo de permiso valido");
				}
			} else {
				throw new Exception("Acceso denegado, no tienes permiso");
			}
		} catch (Exception e) {
			return new ResponseEntity( e.getMessage(), HttpStatus.FORBIDDEN);
		}
	}
}
