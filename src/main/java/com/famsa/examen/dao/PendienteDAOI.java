package com.famsa.examen.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.famsa.examen.model.Pendiente;

@Repository
public class PendienteDAOI implements PendientesDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Pendiente pendiente) {
	   sessionFactory.getCurrentSession().save(pendiente);
	   return pendiente.getIdPendiente();
   }

   @Override
   public Pendiente get(long id) {
	   return sessionFactory.getCurrentSession().get(Pendiente.class, id);
   }

   @Override
   public List<Pendiente> list() {
	   Session session = sessionFactory.getCurrentSession();
	   CriteriaBuilder cb = session.getCriteriaBuilder();
	   CriteriaQuery<Pendiente> cq = cb.createQuery(Pendiente.class);
	   Root<Pendiente> root = cq.from(Pendiente.class);
	   cq.select(root);
	   Query<Pendiente> query = session.createQuery(cq);
	   return query.getResultList();
   }

   @Override
   public void update(long id, Pendiente pendiente) {
	   Session session = sessionFactory.getCurrentSession();
	   Pendiente pendiente2 = session.byId(Pendiente.class).load(id);
	   pendiente2.setNombre(pendiente.getNombre());
	   pendiente2.setDescripcion(pendiente.getDescripcion());
	   pendiente2.setFecha(pendiente.getFecha());
	   session.flush();
   }

   @Override
   public void delete(long id) {
	   Session session = sessionFactory.getCurrentSession();
	   Pendiente pendiente = session.byId(Pendiente.class).load(id);
	   session.delete(pendiente);
   }

}
