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
	
	
	//Agregar Evento
	@GetMapping("/agregarEvento")
	public String agregarEvento() {
		return "agregarEvento";
	}

	//Agregar Evento
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
			model.addAttribute("msgError", new InfoMessage("❌¡Ya existe un evento con datos del nuevo o el evento no se pudo agregar por valor no valido!", 0));
		}

		model.addAttribute("eventos", eventRepository.findAll());
		
		return "eventos";
	}

		//Editar Evento
		@GetMapping("/editarEvento")
		public String editarEvento(Model model, @RequestParam(name = "eventid") Long eventid) {
			String destino = "eventos";
			try {
				Evento event = eventRepository.findById(eventid).orElseThrow(() -> new IllegalArgumentException("Invalid event Id:" + eventid));
				model.addAttribute("evento", event);
				destino = "editarEvento";
			} catch (Exception e) {
				model.addAttribute("msgError", new InfoMessage("❌¡No se pudo modificar el evento correctamente!", 0));
			}
			return destino;
		}

	//Editar Evento
	@PostMapping("/editarEvento")
	public String editarEventoRoot(Model model, @RequestParam(name = "eventid") Long eventid, @RequestParam(name = "eventname") String eventname, @RequestParam(name = "tema") String tema, @RequestParam(name = "starttime") String startTime, 
	@RequestParam(name = "endtime") String endTime, @RequestParam(name = "enabled") Boolean available, @RequestParam(name = "eventpreference") Boolean eventPreference, 
	@RequestParam(name = "coordinates") String coordinates, @RequestParam(name = "videomeeting") String videomeeting, @RequestParam(name = "userowner") Long userOwner, @RequestParam(name = "usersummoner") Long userSummoner) {

		try {
			Evento event = new Evento();
			if(userSummoner==0){
				event.setEventID(eventid);
				event.setEventName(eventname);
				event.setTema(tema);
				event.setStartTime(startTime);
				event.setEndTime(endTime);
				event.setAvailable(available);
				event.setEventPreference(eventPreference);
				event.setCoordinates(coordinates);
				event.setVideomeeting(videomeeting);
				event.setUserOwner(userRepository.findById(userOwner).orElseThrow(() ->  new IllegalArgumentException("Usuario owner no encontrado")));
			}else{
				event.setEventID(eventid);
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
			}
			
			eventRepository.save(event);
			model.addAttribute("msgError", new InfoMessage("➕¡El evento se agregó correctamente!", 0));
		} catch (Exception e) {
			model.addAttribute("msgError", new InfoMessage("❌¡Ya existe un evento con datos del nuevo o el evento no se pudo agregar por valor no valido!", 0));
		}

		model.addAttribute("eventos", eventRepository.findAll());
		
		return "eventos";
	}

	@PostMapping("/eliminarEvento")
	public String eliminarEvento(Model model, @RequestParam(name = "eventid") Long eventid) {
		try {
			eventRepository.deleteById(eventid);
			model.addAttribute("msgError", new InfoMessage("➖¡El evento se eliminó correctamente!", 0));
		} catch (Exception e) {
			model.addAttribute("msgError", new InfoMessage("❌¡No se pudo eliminar el evento!", 0));
		}
		model.addAttribute("eventos", eventRepository.findAll());
		return "eventos";
	}
}
