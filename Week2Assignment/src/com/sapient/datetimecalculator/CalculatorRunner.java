package com.sapient.datetimecalculator;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.sapient.datetimecalculator.history.HistoryDAO;
import com.sapient.datetimecalculator.sessionmanager.CSVSession;
import com.sapient.datetimecalculator.sessionmanager.Session;

public class CalculatorRunner {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.displayMenu();

		HistoryDAO historyDao = new HistoryDAO();

		LocalDateTime d1, d2, d3;
		DateTime n, result;
		Session csv = new CSVSession();

		int choice = cal.enterChoice();
		int count = 0;
		while (choice != -1) {
			switch (choice) {
			case 1:
				d1 = cal.enterDate();
				n = cal.enterN();
				result = cal.addTwoDates(d1, n);
				cal.displayResult(result);
				count++;
				historyDao.insert(count, choice, d1, n, result);
				break;
			case 2:
				d1 = cal.enterDate();
				d2 = cal.enterDate();
				result = cal.subtractTwoDates(d1, d2);
				cal.displayResult(result);
				count++;
				historyDao.insert(count, choice, d1, d2, result);
				break;
			case 3:
				d1 = cal.enterDate();
				n = cal.enterN();
				d3 = cal.addNToGivenDate(d1, n);
				cal.displayDate(d3);
				count++;
				historyDao.insert(count, choice, d1, n, d3);
				break;
			case 4:
				d1 = cal.enterDate();
				n = cal.enterN();
				d3 = cal.subtractNToGivenDate(d1, n);
				cal.displayDate(d3);
				count++;
				historyDao.insert(count, choice, d1, n, d3);
				break;
			case 5:
				d1 = cal.enterDate();
				String resultDayOfWeek = cal.dayOfWeek(d1);
				System.out.println("Result: " + resultDayOfWeek);
				count++;
				historyDao.insert(count, choice, d1, resultDayOfWeek);
				break;
			case 6:
				d1 = cal.enterDate();
				int resultWeekNumber = cal.weekNumber(d1);
				System.out.println("Result: " + resultWeekNumber);
				count++;
				historyDao.insert(count, choice, d1, resultWeekNumber);
				break;
			case 7:
				System.out.println(historyDao);
				break;
			case 8:
				String csvReadFilename = "out.csv";
				ArrayList<HistoryDAO> sessionsHistory = csv.read(csvReadFilename);
				System.out.println(sessionsHistory);
				break;
			}
			choice = cal.enterChoice();
		}

		String csvWriteFilename = "out.csv";
//		csv.write(historyDao, csvWriteFilename);
		System.out.println("Exiting");
	}

}
