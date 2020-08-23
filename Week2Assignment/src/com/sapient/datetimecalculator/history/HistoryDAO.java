package com.sapient.datetimecalculator.history;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.sapient.datetimecalculator.DateTime;

public class HistoryDAO {

	private Map<Integer, History> sessionStorage;

	public HistoryDAO() {
		this.sessionStorage = new HashMap<Integer, History>();
	}

	public void insert(int key, int choice, LocalDateTime d1, LocalDateTime d2, DateTime result) {
		History history = new History();
		history.setChoice(choice);
		history.setD1(d1);
		history.setD2(d2);
		history.setResultN(result);
		sessionStorage.put(key, history);
	}

	public void insert(int key, int choice, LocalDateTime d1, DateTime n, DateTime result) {
		History history = new History();
		history.setChoice(choice);
		history.setD1(d1);
		history.setN(n);
		history.setResultN(result);
		sessionStorage.put(key, history);
	}

	public void insert(int key, int choice, LocalDateTime d1, DateTime n, LocalDateTime d3) {
		History history = new History();
		history.setChoice(choice);
		history.setD1(d1);
		history.setN(n);
		history.setResult(d3);
		sessionStorage.put(key, history);
	}

	public void insert(int key, int choice, LocalDateTime d1, String resultDayOfWeek) {
		History history = new History();
		history.setChoice(choice);
		history.setD1(d1);
		history.setResultDayOfWeek(resultDayOfWeek);
		sessionStorage.put(key, history);
	}

	public void insert(int key, int choice, LocalDateTime d1, int resultWeekNumber) {
		History history = new History();
		history.setChoice(choice);
		history.setD1(d1);
		history.setResultWeekNumber(resultWeekNumber);
		sessionStorage.put(key, history);
	}

	@Override
	public String toString() {
		return "HistoryDAO [sessionStorage=" + sessionStorage + "]\n";
	}

}
