package com.jmfi.apirest.controllers;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.jmfi.apirest.models.entity.Empleado;
import com.jmfi.apirest.models.services.IEmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {

	@Autowired  // Inyección de dependencia
	private IEmpleadoServiceImpl empleadoService;
	
	@GetMapping("/listar")
	public List<Empleado> getEmpleados(){	
		return empleadoService.findAll();
	}
	
	@RequestMapping(value="{empleadoId}")  // --> /api/{empleadoId}
	public Empleado getEmpleadoById(@PathVariable("empleadoId") Long empleadoId){	
		return empleadoService.getEmpleadoByID(empleadoId);
	}
	
	@PostMapping
	public Long createEmpleado(@RequestBody Empleado empleado){
 	     return empleadoService.createEmpleado(empleado);		 
	}
	
	@DeleteMapping(value="{empleadoId}")  // --> /api/{empleadoId}
	public void deleteEmpleado(@PathVariable("empleadoId") Long empleadoId) {
		empleadoService.deleteEmpleado(empleadoId);
	}
 
	@PutMapping
	public Empleado updateEmpleado(@RequestBody Empleado empleado){
 	     return empleadoService.updateEmpleado(empleado);		 
	}
	
	 
}
