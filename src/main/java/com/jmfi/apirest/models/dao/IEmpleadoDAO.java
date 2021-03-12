package com.jmfi.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.jmfi.apirest.models.entity.Empleado;

public interface IEmpleadoDAO extends CrudRepository<Empleado, Long> {

}
