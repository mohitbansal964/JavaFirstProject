package com.sapient.datetimecalculator;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.datetimecalculator.bo.Menu;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Menu menu;

	public MenuServlet() {
		super();
		menu = new Menu();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> choices = menu.getChoices();
		request.setAttribute("choicesList", choices);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/menu.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> choices = menu.getChoices();
		int choice = Integer.parseInt(request.getParameter("choice"));
		boolean date2 = false, date3 = false;
		if (choice == 1) {
			date2 = true;
		} else if (choice == 0 || choice == 2 || choice == 3) {
			date3 = true;
		}
		request.setAttribute("choiceIndex", choice);
		request.setAttribute("choice", choices.get(choice));
		request.setAttribute("date2", date2);
		request.setAttribute("date3", date3);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/input.jsp");

		dispatcher.forward(request, response);

	}

}
