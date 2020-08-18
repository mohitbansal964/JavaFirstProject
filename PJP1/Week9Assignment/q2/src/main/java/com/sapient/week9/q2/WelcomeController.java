package com.sapient.week9.q2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
	@GetMapping({ "/", "/welcome" })
	public String hello(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		model.addAttribute("name", name);
		return "welcome";
	}
}
