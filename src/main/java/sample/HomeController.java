package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sample.api.facebook.Facebook;

@Controller
public class HomeController {


	@Autowired
	public HomeController() {
	}
	
	@GetMapping("/")
	public String home(Model model,Facebook facebook) {

		model.addAttribute("profile", facebook.getProfile());
		return "home";
	}
	@GetMapping("/pageslist")
	public String pageslist(Model model,Facebook facebook){
		model.addAttribute("pagesList", facebook.getPages());
		return "pageslist";
	}

}
