package com.sapient.datetimecalculator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.datetimecalculator.bo.CalculatorInputBo;
import com.sapient.datetimecalculator.bo.CalculatorOutputBo;
import com.sapient.datetimecalculator.dbms.CalculatorInput;
import com.sapient.datetimecalculator.dbms.CalculatorOutput;
import com.sapient.datetimecalculator.operations.AddTwoDates;
import com.sapient.datetimecalculator.operations.CalculatorOperation;

@WebServlet("/input/0")
public class AddTwoDatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CalculatorInputBo inputBo;
	private CalculatorOperation op;
	private CalculatorOutputBo outputBo;

	public AddTwoDatesServlet() {
		super();
		inputBo = new CalculatorInputBo();
		op = new AddTwoDates();
		outputBo = new CalculatorOutputBo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/data-time-calculator-with-jsp/menu");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int choice = 0;
		String dateText1 = request.getParameter("date1");
		LocalDateTime date1 = LocalDateTime.parse(dateText1, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

		String nDays = request.getParameter("noOfDays");
		String nWeeks = request.getParameter("noOfWeeks");
		String nMonths = request.getParameter("noOfMonths");
		String nYears = request.getParameter("noOfYears");
		int numberOfDays = Integer.parseInt(nDays == "null" ? "0" : nDays);
		int numberOfWeeks = Integer.parseInt(nWeeks == "null" ? "0" : nWeeks);
		int numberOfMonths = Integer.parseInt(nMonths == "null" ? "0" : nMonths);
		int numberOfYears = Integer.parseInt(nYears == "null" ? "0" : nYears);

		CalculatorInput input = inputBo.convert(choice, date1, null, numberOfDays, numberOfWeeks, numberOfMonths,
				numberOfYears);
		CalculatorOutput output = op.perform(input);
		Integer outId = outputBo.storeOutput(output, choice);

		request.setAttribute("output", output.getNumericalDate());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/addTwoDates.jsp");
		dispatcher.forward(request, response);

	}

}
