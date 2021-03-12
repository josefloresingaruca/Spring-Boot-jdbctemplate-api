package com.jmfi.apirest;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsJmfiApirestApplication {
	
	
	//Esto se hace para configurar el manejo de fechas
	 @PostConstruct
	    void started() {
	        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	    }

	public static void main(String[] args) {
		SpringApplication.run(WsJmfiApirestApplication.class, args);
	}

	
}
