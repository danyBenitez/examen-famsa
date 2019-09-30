package com.famsa.examen.dao;

import java.util.List;

import com.famsa.examen.model.Pendiente;

public interface PendientesDAO {
	
	
	long save(Pendiente pendiente);

	Pendiente get(long id);

	List<Pendiente> list();

	void update(long id, Pendiente pendiente);

	void delete(long id);

}
