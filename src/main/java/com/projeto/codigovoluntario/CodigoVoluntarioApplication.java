package com.projeto.codigovoluntario;

import com.projeto.codigovoluntario.model.Usuario;
import com.projeto.codigovoluntario.service.usuarioService;
import com.projeto.codigovoluntario.usuarioUtil.validaUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class CodigoVoluntarioApplication {


    Usuario user = new Usuario("admin", "admin");

	public static void main(String[] args) {
		SpringApplication.run(CodigoVoluntarioApplication.class, args);
	}

}
