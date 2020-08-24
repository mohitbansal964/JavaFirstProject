package com.sapient.datetimecalculator.sessionmanager;

import java.util.ArrayList;

import com.sapient.datetimecalculator.history.HistoryDAO;

public interface Session {
	public ArrayList<HistoryDAO> read(String filename);

	public void write(HistoryDAO historyDao, String filename);

}
