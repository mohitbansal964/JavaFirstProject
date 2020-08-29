package com.sapient.datetimecalculator.bo;

import com.sapient.datetimecalculator.dbms.CalculatorOutput;
import com.sapient.datetimecalculator.dbms.CalculatorOutputDao;
import com.sapient.datetimecalculator.dbms.NumericalDateDao;

public class CalculatorOutputBo {
	private NumericalDateDao numDateDao;
	private CalculatorOutputDao outDao;

	public CalculatorOutputBo() {
		numDateDao = new NumericalDateDao();
		outDao = new CalculatorOutputDao();
	}

	public Integer storeOutput(CalculatorOutput out, int choice) {
		if (choice == 0 || choice == 1) {
			numDateDao.insert(out.getNumericalDate());
		}
		Integer id = outDao.insert(out);
		return id;

	}
}
