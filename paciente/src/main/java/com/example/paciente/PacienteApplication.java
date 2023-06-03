package com.example.paciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class PacienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacienteApplication.class, args);
	}
   @GetMapping("/index")
	public String welcome(Model model) {
   		model.addAttribute("nombre","diez");
		   return "index";
   }
}
