package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(path = {"/","/chao"})
	public String hello() {
		return "chao";
	}
}
