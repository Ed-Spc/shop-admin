package springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {	
		this.userService = userService;
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET,value="/user/list")
	public String findAll(Model model) {
		List<User> users=userService.finAll();
			model.addAttribute("users", users);
		return "user-list";
	}
}
