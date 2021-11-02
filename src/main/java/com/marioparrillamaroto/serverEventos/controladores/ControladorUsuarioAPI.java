package com.marioparrillamaroto.serverEventos.controladores;

import java.util.ArrayList;

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

import com.marioparrillamaroto.serverEventos.entity.Usuario;
import com.marioparrillamaroto.serverEventos.repository.UserRepository;

@RestController
@RequestMapping("/api/")
public class ControladorUsuarioAPI {
	
	@Autowired
	private UserRepository userRepository;
	
	//Buscar Usuarios
	@GetMapping("/usuario")
	public ResponseEntity<Usuario> getUsuarios(){
		return new ResponseEntity( userRepository.findAll(), HttpStatus.OK);
	}
	
	//Buscar Usuario
	@GetMapping("/usuario/{userID}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("userID") Long userID){
		return new ResponseEntity( userRepository.findById(userID).orElse(null), HttpStatus.OK);
	}
	
	//Guardar Usuario
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario user) {
		userRepository.save(user);
		return new ResponseEntity(userRepository.findById(user.getUserID()).orElse(null),HttpStatus.OK);
	}
	
	//Borrar Usuario
	@DeleteMapping("/usuario/{userID}")
	public ResponseEntity<Usuario> eliminarUsuario(@PathVariable("userID") Long userID) {
		userRepository.deleteById(userID);
		return new ResponseEntity(null, HttpStatus.OK);
	}
	
	//Modificar Usuario
	@PutMapping("/usuario/{userID}")
	public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario user) {
		userRepository.save(user);
		return new ResponseEntity(userRepository.findById(user.getUserID()).orElse(null),HttpStatus.OK);
	}
}
