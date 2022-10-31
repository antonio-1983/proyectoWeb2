package com.web2.proyecto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ProyectoApplicationTests {

	@Test
	void contextLoads() {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		String passEncriptado = "Antonio1"; //El pass que quieras para el usuario, PARA GENERAR HAY QUE PONER --> BOTON IZQ EN "POM.XML" RUN AS --> MAVEN INSTALL
		String passEncriptado1 = "Antonio2";
		System.out.println("PALABRA: " +passEncriptado +" "+pe.encode(passEncriptado)+" "+"PALABRA2: " +passEncriptado1 +" "+pe.encode(passEncriptado1)); //SE GENERA LA PALABRA, LA COPIAMOS Y LA INSERTAMOS EN EL PASSWORD DEL USER
		
	}
	
}
