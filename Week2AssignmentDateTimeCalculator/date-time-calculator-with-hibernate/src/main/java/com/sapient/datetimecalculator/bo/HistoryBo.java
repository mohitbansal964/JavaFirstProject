package com.sapient.datetimecalculator.bo;

import java.time.LocalDateTime;
import java.util.List;

import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;
import com.sapient.datetimecalculator.dbms.History;
import com.sapient.datetimecalculator.dbms.HistoryDao;

public class HistoryBo {
	private HistoryDao historyDao;

	public HistoryBo() {
		historyDao = new HistoryDao();
	}

	public void addHistory(LocalDateTime now, CalculatorInput input, CalculatorOutput output) {
		History history = new History(now, input, output);
		Integer id = historyDao.insert(history);
	}

	public void displaySessionHistory(LocalDateTime now) {
		List<History> sessionHistory = historyDao.findOneSession(now);
		for (History history : sessionHistory) {
			CalculatorInput input = history.getInput();
			CalculatorOutput output = history.getOutput();
			System.out.print(input + " ");
			System.out.println(output);
		}
	}

	public void displayLast100SessionsHistory() {
		List<History> last100SessionHistory = historyDao.find100Sessions();
		for (History history : last100SessionHistory) {
			CalculatorInput input = history.getInput();
			CalculatorOutput output = history.getOutput();
			System.out.print(input + " ");
			System.out.println(output);
		}
	}

}
