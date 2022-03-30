package com.marioparrillamaroto.serverEventos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.marioparrillamaroto.serverEventos.controladores.ControladorUsuario;
import com.marioparrillamaroto.serverEventos.controladores.controladorIndex;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

@SpringBootTest
class ServerEventosApplicationTests {

	@Test
	void pruebaRespuestaLogin() {
		controladorIndex controladorIndex = new controladorIndex();
		String result = controladorIndex.login();
		assertEquals(result, "login");
	}

	@Test
	void pruebaAgregarUsuario() {
		ControladorUsuario cUsuario = new ControladorUsuario();

		Model model = ;
		String result = cUsuario.agregarUsuarioRoot(model, "prueba", "prueba", "prueba@prueba.com", "678434567");
		assertEquals(result, "usuarios");
	}

}
