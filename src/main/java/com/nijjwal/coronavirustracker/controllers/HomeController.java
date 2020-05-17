package com.nijjwal.coronavirustracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nijjwal.coronavirustracker.services.CoronaVirusDataService;

@Controller
/**
 * @Controller annotation - this is not a REST API hence we can't
 *             use @RestController annotation here. This controller will return
 *             a name that will map to a page template. Thymeleaf will map it
 *             correctly.
 * @author Nijjwal
 *
 */
public class HomeController {

	@Autowired
	public CoronaVirusDataService locationStats;

	@GetMapping("/")
	public String home(Model model) {
		// Here home is the name of the template Thymeleaf maps to
		model.addAttribute("locationStats", locationStats.getAllStats());

		return "home";
	}
}
