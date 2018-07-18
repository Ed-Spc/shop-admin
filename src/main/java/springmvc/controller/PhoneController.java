package springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.model.Phone;
import springmvc.service.PhoneService;

@Controller
@EnableWebSecurity
public class PhoneController {
	private PhoneService phoneService ;

	@Autowired
	public PhoneController(PhoneService phoneService) {
		this.phoneService = phoneService;
	}
/*==========================================================================================*/	
							/*ÇëÇó¿ØÖÆ*/
/*==========================================================================================*/	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/phones/") 
	public String list(Model model) {
		List<Phone> phones= phoneService.findAll();
		model.addAttribute("phones", phones);
		
		return "phone-list";
	} 
	
	@RequestMapping(method=RequestMethod.GET, value="/phones/add") 
	public String add(Model model) {
		model.addAttribute("phone", new Phone());	
		return "phone-edit";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/phones/add") 
	public String create(@ModelAttribute @Valid Phone phone,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "phone-edit";
		}
		
		phoneService.create(phone);
		return "phones/";
	}
	

	@RequestMapping(method=RequestMethod.GET, value="edit/{id}") 
	public String update1(@PathVariable int id,Model model) {
		Phone phone=phoneService.findOne(id);	
		model.addAttribute("phone", phone);
		return "phone-edit";
	} 
	
	@RequestMapping(method=RequestMethod.POST, value="edit/{id}") 
	public String update2(@PathVariable int id,@ModelAttribute  @Valid Phone phone,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "phone-edit";
		}
		
		phoneService.update(phone);
		return "phones/";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="delete/{id}") 
	public String delete(@PathVariable int id) {	
		System.out.println(id);
		phoneService.delete(id);
		return "phones/";
	}
}
