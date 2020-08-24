package com.sapient.datetimecalculator.sessionmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.sapient.datetimecalculator.DateTime;
import com.sapient.datetimecalculator.history.History;
import com.sapient.datetimecalculator.history.HistoryDAO;

public class CSVSession implements Session {

	@Override
	public ArrayList<HistoryDAO> read(String filename) {
		ArrayList<HistoryDAO> sessionsHistory = new ArrayList<HistoryDAO>();
		try (Scanner scan = new Scanner(new File(filename))) {
			boolean flag = true;
			HistoryDAO historyDao = null;
			History history;
			Map<Integer, History> sessionStorage = new HashMap<Integer, History>();
			String prevSessionDate = "";
			while (scan.hasNext()) {
				String row = scan.nextLine();
				String[] values = row.split(",", -1);
				if (flag) {
					flag = false;
					prevSessionDate = values[0];
				} else if (!values[0].equals(prevSessionDate)) {
					prevSessionDate = values[0];
					historyDao = new HistoryDAO();
					historyDao.setSessionStorage(sessionStorage);
					sessionsHistory.add(historyDao);
					sessionStorage = new HashMap<Integer, History>();
				}
				int key = Integer.parseInt(values[1]);
				int choice = Integer.parseInt(values[2]);
				LocalDateTime d1 = values[3].isEmpty() ? null : LocalDateTime.parse(values[3]);
				LocalDateTime d2 = values[4].isEmpty() ? null : LocalDateTime.parse(values[4]);
				DateTime n = (values[5].isEmpty() && values[6].isEmpty() && values[7].isEmpty() && values[8].isEmpty())
						? null
						: new DateTime(Integer.parseInt(values[5]), Integer.parseInt(values[6]),
								Integer.parseInt(values[7]), Integer.parseInt(values[8]));
				LocalDateTime result = values[9].isEmpty() ? null : LocalDateTime.parse(values[9]);
				DateTime resultN = (values[10].isEmpty() && values[11].isEmpty() && values[12].isEmpty()
						&& values[13].isEmpty()) ? null
								: new DateTime(Integer.parseInt(values[10]), Integer.parseInt(values[11]),
										Integer.parseInt(values[12]), Integer.parseInt(values[13]));
				String resultDayOfWeek = values[14];
				int resultWeekNumber = values[15].isEmpty() ? 0 : Integer.parseInt(values[15]);

				history = new History();
				history.setChoice(choice);
				history.setD1(d1);
				history.setD2(d2);
				history.setN(n);
				history.setResult(result);
				history.setResultN(resultN);
				history.setResultDayOfWeek(resultDayOfWeek);
				history.setResultWeekNumber(resultWeekNumber);

				sessionStorage.put(key, history);

			}
			historyDao = new HistoryDAO();
			historyDao.setSessionStorage(sessionStorage);
			sessionsHistory.add(historyDao);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sessionsHistory;
	}

	@Override
	public void write(HistoryDAO historyDao, String filename) {
		Map<Integer, History> sessionStorage = historyDao.getSessionStorage();
		LocalDateTime now = LocalDateTime.now();
		StringBuilder csvString = new StringBuilder();
		for (Map.Entry<Integer, History> entry : sessionStorage.entrySet()) {
			StringBuilder csvOneLine = new StringBuilder();
			csvOneLine.append(now + ",");
			csvOneLine.append(entry.getKey() + ",");
			csvOneLine.append(entry.getValue().toCSVString());
			csvString.append(csvOneLine.toString());
		}
		try (FileWriter csvWriter = new FileWriter(filename, true)) {
			csvWriter.append(csvString.toString());
			csvWriter.flush();
			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
