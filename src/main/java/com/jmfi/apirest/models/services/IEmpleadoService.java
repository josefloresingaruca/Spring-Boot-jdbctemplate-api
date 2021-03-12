package com.jmfi.apirest.models.services;

import java.util.List;

import com.jmfi.apirest.models.entity.Empleado;

public interface IEmpleadoService {

	public List<Empleado> findAll();	
	public Empleado getEmpleadoByID(Long id);
	public Long createEmpleado(Empleado empleado);
	public void deleteEmpleado(Long id);
	public Empleado updateEmpleado(Empleado empleado);
	
	
}
