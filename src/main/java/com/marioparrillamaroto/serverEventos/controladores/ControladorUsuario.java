package com.marioparrillamaroto.serverEventos.controladores;

import com.marioparrillamaroto.serverEventos.entity.Usuario;
import com.marioparrillamaroto.serverEventos.entity.InfoMessage;
import com.marioparrillamaroto.serverEventos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorUsuario {

	@Autowired
	private UserRepository userRepository;

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

	@PostMapping("/agregarUsuario")
	public String agregarUsuarioRoot(Model model, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password
	, @RequestParam(name = "email") String email, @RequestParam(name = "phonenumber") String phonenumber) {

		try {
			Usuario user = new Usuario();
			user.setUsername(username);
			user.setPassword(password);
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

	@PostMapping("/editarUsuario")
	public String editarUsuarioRoot(Model model, @RequestParam(name = "userid") Long userid, @RequestParam(name = "username") String username, @RequestParam(name = "password") String password
	, @RequestParam(name = "email") String email, @RequestParam(name = "phonenumber") String phonenumber) {

		try {
			Usuario user = new Usuario();
			user.setUserID(userid);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhonenumber(phonenumber);
			user.setEnabled(true);
			user.setCmsAdmin(false);

			userRepository.save(user);
			model.addAttribute("msgError", new InfoMessage("📝¡El usuario se modificó correctamente!", 0));
		} catch (Exception e) {
			model.addAttribute("msgError", new InfoMessage("❌¡No se pudo modificar el usuario correctamente!", 0));
		}

		model.addAttribute("usuarios", userRepository.findAll());
		return "usuarios";
	}

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
