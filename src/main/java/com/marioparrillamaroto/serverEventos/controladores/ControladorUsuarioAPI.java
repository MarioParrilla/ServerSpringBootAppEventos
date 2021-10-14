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

import com.marioparrillamaroto.serverEventos.entity.Usuario;
import com.marioparrillamaroto.serverEventos.repository.UserRepository;

@RestController
@RequestMapping("/api/")
public class ControladorUsuarioAPI {
	
	@Autowired
	private UserRepository userRepository;
	
	//Buscar Usuarios
	@GetMapping("/usuario")
	public ArrayList<Usuario> getUsuarios(){
		return (ArrayList<Usuario>) userRepository.findAll();
	}
	
	//Buscar Usuario
	@GetMapping("/usuario/{userID}")
	public Usuario getUsuario(@PathVariable("userID") Long userID){
		return userRepository.findById(userID).orElse(null);
	}
	
	//Guardar Usuario
	@PostMapping("/usuario")
	public String guardarUsuario(@RequestBody Usuario user) {
		userRepository.save(user);
		return "usuario";
	}
	
	//Borrar Usuario
	@DeleteMapping("/usuario/{userID}")
	public String eliminarUsuario(@PathVariable("userID") Long userID) {
		userRepository.deleteById(userID);
		return "usuario";
	}
	
	//Modificar Usuario
	@PutMapping("/usuario/{userID}")
	public String modificarUsuario(@RequestBody Usuario user) {
		userRepository.save(user);
		return "usuario";
	}
}
