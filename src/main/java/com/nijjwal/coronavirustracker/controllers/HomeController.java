package com.nijjwal.coronavirustracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

	@GetMapping("/")
	public String home() {
		// Here home is the name of the template Thymeleaf maps to
		return "home";
	}
}
