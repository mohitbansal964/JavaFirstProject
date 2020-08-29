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
import com.sapient.datetimecalculator.operations.CalculatorOperation;
import com.sapient.datetimecalculator.operations.SubtractTwoDates;

@WebServlet("/input/1")
public class SubtractTwoDatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CalculatorInputBo inputBo;
	private CalculatorOperation op;
	private CalculatorOutputBo outputBo;

	public SubtractTwoDatesServlet() {
		super();
		inputBo = new CalculatorInputBo();
		op = new SubtractTwoDates();
		outputBo = new CalculatorOutputBo();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/data-time-calculator-with-jsp/menu");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int choice = 1;
		String dateText1 = request.getParameter("date1");
		String dateText2 = request.getParameter("date2");
		LocalDateTime date1 = LocalDateTime.parse(dateText1, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		LocalDateTime date2 = LocalDateTime.parse(dateText2, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

		CalculatorInput input = inputBo.convert(choice, date1, date2, -1, -1, -1, -1);
		CalculatorOutput output = op.perform(input);
		Integer outId = outputBo.storeOutput(output, choice);

		request.setAttribute("output", output.getNumericalDate());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/subtractTwoDates.jsp");
		dispatcher.forward(request, response);

	}
}
