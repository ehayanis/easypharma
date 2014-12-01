package com.mm.app.service;

import java.util.List;

import com.mm.app.model.Operator;


public interface OperatorService {

	public List<Operator> getOperators();
	
	public Operator findOperator(int id);

	public void addOperator(Operator operator);
}

