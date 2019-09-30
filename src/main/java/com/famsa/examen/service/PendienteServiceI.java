package com.famsa.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.famsa.examen.dao.PendientesDAO;
import com.famsa.examen.model.Pendiente;

@Service
@Transactional(readOnly = true)
public class PendienteServiceI implements PendienteService {

	@Autowired
	private PendientesDAO pendienteDAO;

	@Transactional
	@Override
	public long save(Pendiente pendiente) {
		return this.pendienteDAO.save(pendiente);
	}

	@Transactional
	@Override
	public Pendiente get(long id) {
		return this.pendienteDAO.get(id);
	}

	@Transactional
	@Override
	public List<Pendiente> list() {
		return this.pendienteDAO.list();
	}

	@Transactional
	@Override
	public void update(long id, Pendiente pendiente) {
		this.pendienteDAO.update(id, pendiente);
	}

	@Transactional
	@Override
	public void delete(long id) {
		this.pendienteDAO.delete(id);
	}
}
