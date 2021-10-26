package com.marioparrillamaroto.serverEventos.controladores;

import com.marioparrillamaroto.serverEventos.entity.Evento;
import com.marioparrillamaroto.serverEventos.entity.InfoMessage;
import com.marioparrillamaroto.serverEventos.repository.EventRepository;
import com.marioparrillamaroto.serverEventos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorEvento {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EventRepository eventRepository;

    @GetMapping("/eventos")
	public String root(Model model) {
		model.addAttribute("msgError", new InfoMessage("", 1));
		model.addAttribute("eventos", eventRepository.findAll());
		return "eventos";
	}
	
	@GetMapping("/agregarEvento")
	public String agregarEvento() {
		return "agregarEvento";
	}

	@PostMapping("/agregarEvento")
	public String agregarEventoRoot(Model model, @RequestParam(name = "eventname") String eventname, @RequestParam(name = "tema") String tema, @RequestParam(name = "starttime") String startTime, 
		@RequestParam(name = "endtime") String endTime, @RequestParam(name = "enabled") Boolean available, @RequestParam(name = "eventpreference") Boolean eventPreference, 
		@RequestParam(name = "coordinates") String coordinates, @RequestParam(name = "videomeeting") String videomeeting, @RequestParam(name = "userowner") Long userOwner, @RequestParam(name = "usersummoner") Long userSummoner) {
	
		try {
			Evento event = new Evento();
			event.setEventName(eventname);
			event.setTema(tema);
			event.setStartTime(startTime);
			event.setEndTime(endTime);
			event.setAvailable(available);
			event.setEventPreference(eventPreference);
			event.setCoordinates(coordinates);
			event.setVideomeeting(videomeeting);
			event.setUserOwner(userRepository.findById(userOwner).orElseThrow(() ->  new IllegalArgumentException("Usuario owner no encontrado")));
			event.setUserSummoner(userRepository.findById(userSummoner).orElseThrow(() -> new IllegalArgumentException("Usuario summoner no encontrado")));
			
			eventRepository.save(event);
			model.addAttribute("msgError", new InfoMessage("➕¡El evento se agregó correctamente!", 0));
		} catch (Exception e) {
			model.addAttribute("msgError", new InfoMessage("❌¡Ya existe un evento con datos del nuevo o el evento no se pudo agregar!", 0));
		}

		model.addAttribute("eventos", eventRepository.findAll());
		
		return "eventos";
	}

	@PostMapping("/editarEvento")
	public String editarEvento() {
		return "editarEvento";
	}

	@PostMapping("/eliminarEvento")
	public String eliminarEvento() {
		return "usuarios";
	}
}
