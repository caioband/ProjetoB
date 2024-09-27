package com.barbearia.projeto.B;

import com.barbearia.projeto.B.usuario.Usuario;
import com.barbearia.projeto.B.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProjetoBApplication {


	public static void main(String[] args) {
		SpringApplication.run(ProjetoBApplication.class, args);
		System.out.println("funfando");
	}
}
