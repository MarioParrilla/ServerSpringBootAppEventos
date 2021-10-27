package com.marioparrillamaroto.serverEventos.controladores;

import com.marioparrillamaroto.serverEventos.entity.Usuario;
import com.marioparrillamaroto.serverEventos.entity.InfoMessage;
import com.marioparrillamaroto.serverEventos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorUsuario {

	@Autowired
	private UserRepository userRepository;

	//Consultar Usuarios
    @GetMapping("/usuarios")
	public String root(Model model) {
		model.addAttribute("msgError", new InfoMessage("", 1));
		model.addAttribute("usuarios", userRepository.findAll());
		return "usuarios";
	}
    
	@GetMapping("/agregarUsuario")
	public String agregarUsuario() {
		return "agregarUsuario";
	}

	//Agregar Usuarios
	@PostMapping("/agregarUsuario")
	public String agregarUsuarioRoot(Model model, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password
	, @RequestParam(name = "email") String email, @RequestParam(name = "phonenumber") String phonenumber) {

		try {
			Usuario user = new Usuario();
			user.setUsername(username);
			user.setPassword(new BCryptPasswordEncoder(4).encode(password));
			user.setEmail(email);
			user.setPhonenumber(phonenumber);
			user.setEnabled(true);
			user.setCmsAdmin(false);
			
			userRepository.save(user);
			model.addAttribute("msgError", new InfoMessage("➕¡El usuario se agregó correctamente!", 0));
		} catch (Exception e) {
			model.addAttribute("msgError", new InfoMessage("❌¡Ya existe un usuario con datos del nuevo!", 0));
		}

		model.addAttribute("usuarios", userRepository.findAll());
		return "usuarios";
	}

	//Editar Usuarios
	@GetMapping("/editarUsuario")
	public String editarUsuario(Model model, @RequestParam(name = "userid") Long userid) {
		String destino = "usuarios";
		try {
			Usuario user = userRepository.findById(userid).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + userid));
			model.addAttribute("usuario", user);
			destino = "editarUsuario";
		} catch (Exception e) {
			model.addAttribute("msgError", new InfoMessage("❌¡No se pudo modificar el usuario correctamente!", 0));
		}
		return destino;
	}

	//Editar Usuarios
	@PostMapping("/editarUsuario")
	public String editarUsuarioRoot(Model model, @RequestParam(name = "userid") Long userid, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password
	, @RequestParam(name = "email") String email, @RequestParam(name = "phonenumber") String phonenumber, @RequestParam(name = "enabled") Boolean enabled, @RequestParam(name = "cmsadmin") Boolean cmsadmin,
	@RequestParam(name = "oldpassword") String oldpassword) {

		try {
			Usuario user = new Usuario();
			user.setUserID(userid);
			user.setUsername(username);
			if(!oldpassword.equals(password)) user.setPassword(new BCryptPasswordEncoder(4).encode(password));
			else user.setPassword(new BCryptPasswordEncoder(4).encode(oldpassword));
			user.setEmail(email);
			user.setPhonenumber(phonenumber);
			user.setEnabled(enabled);
			user.setCmsAdmin(cmsadmin);

			userRepository.save(user);
			model.addAttribute("msgError", new InfoMessage("📝¡El usuario se modificó correctamente!", 0));
		} catch (Exception e) {
			model.addAttribute("msgError", new InfoMessage("❌¡No se pudo modificar el usuario correctamente, algún dato ya existen en algún usuario!", 0));
		}

		model.addAttribute("usuarios", userRepository.findAll());
		return "usuarios";
	}

	//Eliminar Usuarios
	@PostMapping("/eliminarUsuario")
	public String eliminarUsuario(Model model, @RequestParam(name = "userid") Long userid) {
		try {
			userRepository.deleteById(userid);
			model.addAttribute("msgError", new InfoMessage("➖¡El usuario se eliminó correctamente!", 0));
		} catch (Exception e) {
			model.addAttribute("msgError", new InfoMessage("❌¡No se pudo eliminar el usuario!", 0));
		}
		model.addAttribute("usuarios", userRepository.findAll());
		return "usuarios";
	}
}
