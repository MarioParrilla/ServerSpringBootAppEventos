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

import com.marioparrillamaroto.serverEventos.entity.Usuario;
import com.marioparrillamaroto.serverEventos.repository.UserRepository;
import com.marioparrillamaroto.serverEventos.services.JWTService;

@RestController
@RequestMapping("/api/")
public class ControladorUsuarioAPI {
	
	@Autowired
	private JWTService jwtService;

	@Autowired
	private UserRepository userRepository;
	
	//Buscar Usuarios
	@GetMapping("/usuario")
	public ResponseEntity<Usuario> getUsuarios(HttpServletRequest request){
		try {
			String token = request.getHeader("Authorization");  
			if (token!=null) {
				if (jwtService.validateToken(request)){
					return new ResponseEntity( userRepository.findAll(), HttpStatus.OK);
				}else{
					throw new Exception("Acceso denegado, no tiene un tiempo de permiso valido");
				}
			} else {
				throw new Exception("Acceso denegado, no tienes permiso");
			}
		} catch (Exception e) {
			return new ResponseEntity( e.getMessage(), HttpStatus.OK);
		}
	}
	
	//Buscar Usuario
	@GetMapping("/usuario/{userID}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("userID") Long userID, HttpServletRequest request){
		try {
			String token = request.getHeader("Authorization");  
			if (token!=null) {
				if (jwtService.validateToken(request)){
					return new ResponseEntity( userRepository.findById(userID).orElse(null), HttpStatus.OK);

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
	
	//Guardar Usuario
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario user, HttpServletRequest request) {
		try {
			String token = request.getHeader("Authorization");  
			if (token!=null) {
				if (jwtService.validateToken(request)){
					userRepository.save(user);
					return new ResponseEntity(userRepository.findById(user.getUserID()).orElse(null),HttpStatus.OK);
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
	
	//Borrar Usuario
	@DeleteMapping("/usuario/{userID}")
	public ResponseEntity<Usuario> eliminarUsuario(@PathVariable("userID") Long userID, HttpServletRequest request) {
		try {
			String token = request.getHeader("Authorization");  
			if (token!=null) {
				if (jwtService.validateToken(request)){
					userRepository.deleteById(userID);
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
	
	//Modificar Usuario
	@PutMapping("/usuario/{userID}")
	public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario user, HttpServletRequest request) {
		userRepository.save(user);
		return new ResponseEntity(userRepository.findById(user.getUserID()).orElse(null),HttpStatus.OK);
	}
}