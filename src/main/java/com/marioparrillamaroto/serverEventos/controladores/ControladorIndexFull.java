package com.marioparrillamaroto.serverEventos.controladores;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.marioparrillamaroto.serverEventos.entity.Evento;
import com.marioparrillamaroto.serverEventos.repository.EventRepository;
import com.marioparrillamaroto.serverEventos.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorIndexFull {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EventRepository eventRepository;

    @GetMapping("/menu")
	public String root(Model model) {
		model.addAttribute("estadisticasUsuario", userRepository.count());
		model.addAttribute("estadisticasEvento", eventRepository.count());

		ArrayList<Evento> listaEventosHoy = (ArrayList) eventRepository.findAll();
		Map<String, Integer> eventos = new LinkedHashMap<String, Integer>();

		LocalDate ld = LocalDate.now();

		for (int i = 1; i <= YearMonth.now().lengthOfMonth(); i++) {
			int contadorTotalDia = 0;
			for (Evento evento : listaEventosHoy) {
				LocalDate date = LocalDate.parse(evento.getEndTime().substring(0,10));
				if (date.getMonth()==LocalDate.now().getMonth()) {
					if (date.getDayOfMonth()==i) contadorTotalDia++;
				}
			}

			String diaEnIngles = LocalDate.of(ld.getYear(), ld.getMonth(), i).getDayOfWeek().toString();
			String diaEnEspanol = "";

			switch (diaEnIngles) {
				case "MONDAY":
					diaEnEspanol = "Lunes";
					break;
				case "TUESDAY":
					diaEnEspanol = "Martes";
					break;
				case "WEDNESDAY":
					diaEnEspanol = "Miercoles";
					break;
				case "THURSDAY":
					diaEnEspanol = "Jueves";
					break;
				case "FRIDAY":
					diaEnEspanol = "Viernes";
					break;
				case "SATURDAY":
					diaEnEspanol = "Sabado";
					break;
				case "SUNDAY":
					diaEnEspanol = "Domingo";
					break;
				default:
					diaEnEspanol = "Null";
					break;
			}

			eventos.put(i+" - "+diaEnEspanol,contadorTotalDia);
		}

		model.addAttribute("estadisticasEventosHoy", eventos);
		return "index";
	}

	@GetMapping("/cerrarSesion")
	public String cerrarSesion(){
		return "redirect:/login";
	}

	@GetMapping("/soporte")
	public String soporte(){
		return "soporte";
	}
}
