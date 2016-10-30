package com.mm.app.dao;

import java.util.List;

import com.mm.app.model.Assurance;
import com.mm.app.model.Operator;

public interface OperatorDao {
	
	public List<Operator> getOperators();
	
	public Operator findOperator(int id);
	
	public void addOperator(Operator operator);
}
