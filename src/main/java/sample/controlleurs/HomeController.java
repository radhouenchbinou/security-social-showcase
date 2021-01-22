package sample.controlleurs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import sample.api.facebook.Facebook;
import sample.services.FacebookService;

@Controller
public class HomeController {
	/**
	 * 
	 */
	private FacebookService facebookService;

	/**
	 * 
	 */
	public HomeController(FacebookService facebookService) {
		this.facebookService = facebookService;
	}

	/**
	 *
	 * @param model
	 * @param facebook
	 * @return
	 */
	@GetMapping("/")
	public String home(Model model,Facebook facebook) {

		model.addAttribute("profile", facebook.getProfile());
		return "home";
	}

	/**
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/pageslist")
	public String pageslist(Model model){
		model.addAttribute("pagesList", facebookService.fetchUserPages());
		return "pageslist";
	}

	/**
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}")
	public String pageDetails(@PathVariable("id") String id,Model model){
		model.addAttribute("pageDetails", facebookService.fetchUserPage(id));
		return "pageDetails";
	}



}
