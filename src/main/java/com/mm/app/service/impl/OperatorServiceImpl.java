package com.mm.app.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.mm.app.dao.OperatorDao;
import com.mm.app.dao.impl.OperatorDaoImpl;
import com.mm.app.model.Assurance;
import com.mm.app.model.Operator;
import com.mm.app.service.OperatorService;

public class OperatorServiceImpl implements OperatorService{
	
	private EntityManager em;
	private OperatorDao dao;
	
	public OperatorServiceImpl(EntityManager em) {
		this.em = em;
		dao = new OperatorDaoImpl(em);
	}

	public List<Operator> getOperators() {
		return dao.getOperators();
	}

	public Operator findOperator(int id) {
		return dao.findOperator(id);
	}

	public void addOperator(Operator operator) {
		dao.addOperator(operator);
		
	}
	
}
