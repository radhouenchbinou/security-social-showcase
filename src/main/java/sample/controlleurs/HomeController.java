package sample.controlleurs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	 * @param facebookService
	 */
	public HomeController(FacebookService facebookService){
		this.facebookService = facebookService;
	}

	/**
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String home(Model model){

		model.addAttribute("profile", facebookService.fetchUserProfileData());
		return "home";
	}
	/**
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/pageslist")
	public String pageslist(Model model, @RequestParam(name = "nextCursor",defaultValue ="last") String nextCursor, @RequestParam(name = "prevCursor",defaultValue ="first") String prevCursor){
		model.addAttribute("pagesList", facebookService.fetchUserPages(nextCursor,prevCursor));
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
