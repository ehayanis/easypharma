package com.mm.app.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mm.app.dao.AssuranceDao;
import com.mm.app.dao.OperatorDao;
import com.mm.app.model.Assurance;
import com.mm.app.model.Operator;

public class OperatorDaoImpl implements OperatorDao{
	
	private EntityManager em;
	
	public OperatorDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Operator> getOperators() {
		TypedQuery<Operator> query = em.createQuery("SELECT o FROM Operator o", Operator.class);
		return query.getResultList();
	}

	@Override
	public Operator findOperator(int id) {
		return em.find(Operator.class, id);
	}

	@Override
	public void addOperator(Operator operator) {
		em.persist(operator);
	}
	
	
	
	
}
