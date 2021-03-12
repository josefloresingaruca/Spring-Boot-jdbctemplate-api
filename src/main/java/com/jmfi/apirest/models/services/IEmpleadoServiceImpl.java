package com.jmfi.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
 
import com.jmfi.apirest.models.dao.IEmpleadoDAO;
import com.jmfi.apirest.models.entity.Empleado;

@Service
public class IEmpleadoServiceImpl implements IEmpleadoService {

	@Autowired //Inyección Dependencia
	public IEmpleadoDAO empleadoDAO;
	
	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>) empleadoDAO.findAll();
	}

	@Override
	public Empleado getEmpleadoByID(Long empleadoId) {
		// TODO Auto-generated method stub
		Optional<Empleado> empleado=empleadoDAO.findById(empleadoId);
		
		if(empleado.isPresent()) {
 			return empleado.get(); 
 		}else {
 			return null; 
 		} 	
	}

	@Override
	public Long createEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		Empleado objEmpleado= empleadoDAO.save(empleado);
		return objEmpleado.getId();
	}

	@Override
	public void deleteEmpleado(Long empleadoId) {
		// TODO Auto-generated method stub
		empleadoDAO.deleteById(empleadoId);
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		Optional<Empleado> optionalEmpleado = empleadoDAO.findById(empleado.getId()); 
		
 		if(optionalEmpleado.isPresent()) {

 			Empleado actEmpleado=optionalEmpleado.get();	
 			//actEmpleado.setId(empleado.getId());
 			actEmpleado.setNombre(empleado.getNombre());
 			actEmpleado.setApellido(empleado.getApellido());
 			actEmpleado.setEmail(empleado.getEmail());
 			actEmpleado.setFecha(empleado.getFecha()); 			 
 			return empleadoDAO.save(actEmpleado); 
 		}else {
 			return null; 
 		} 
	}
 
}
