package com.firstbit.contacts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	DataService dataService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getUsers(Model model) {

		List<User> employeeList = dataService.getList();
		model.addAttribute("users", employeeList);

		return "userspage";
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	public String getAdd(Model model) {
		// logger.debug("Received request to show add page");

		// Create new Person and add to model
		// This is the formBackingOBject
		model.addAttribute("userAttribute", new User());

		// This will resolve to /WEB-INF/jsp/addpage.jsp
		return "addUser";
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public String inserData(@ModelAttribute User user) {
		if (user != null)
			dataService.insertRow(user);
		return "redirect:/";
	}

	@RequestMapping("/users/edit")
	public ModelAndView editUser(@RequestParam int id, @ModelAttribute User employee) {
		User employeeObject = dataService.getRowById(id);
		return new ModelAndView("editUser", "user", employeeObject);
	}

	@RequestMapping("/users/update")
	public ModelAndView updateUser(@RequestParam int id, @ModelAttribute User employee) {
		employee.setId(id);
		dataService.updateRow(employee);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/users/delete")
	public ModelAndView deleteUser(@RequestParam int id) {
		dataService.deleteRow(id);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/contact/list", method = RequestMethod.GET)
	public String getContactList(@RequestParam int id, @RequestParam String name, @RequestParam String lastname,
			Model model) {

		// Create new Person and add to model
		// This is the formBackingOBjec
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setLastname(lastname);

		model.addAttribute("user", user);

		List<Contact> employeeList = dataService.getContactList(id);
		model.addAttribute("contacts", employeeList);

		return "contacts";
	}

	@RequestMapping(value = "/contact/add", method = RequestMethod.GET)
	public String getAddContact(@RequestParam int id, Model model) {
		// logger.debug("Received request to show add page");

		// Create new Person and add to model
		// This is the formBackingOBjec

		model.addAttribute("contactAttribute", new Contact());

		User user = new User();
		user.setId(id);

		model.addAttribute("user", user);

		// This will resolve to /WEB-INF/jsp/addpage.jsp
		return "addContact";
	}

	@RequestMapping(value = "/contact/add", method = RequestMethod.POST)
	public String inserContact(@RequestParam int id, @ModelAttribute Contact contact) {
		if (contact != null) {
			contact.setUser_id(id);
			System.out.println("id = " + contact.getId());
			System.out.println("phone = " + contact.getPhone());
			System.out.println("user_id = " + contact.getUser_id());
			dataService.insertContact(contact);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/contact/remove")
	public String deleteOneContact(@RequestParam int id,Model model){
		dataService.deleteContact(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/contact/edit")
	public String editContact(@RequestParam int id, @ModelAttribute Contact contact, Model model){
		
		Contact send = dataService.getContact(id);
		
		model.addAttribute("contact", send);
		
		return "editContact";
	}
	
	@RequestMapping(value = "/contact/update")
	public String updateContact(@RequestParam int id, @ModelAttribute Contact contact, Model model){
		
		contact.setId(id);
		
		dataService.updateContact(contact);
		
		return "redirect:/";
	}
	
/*

	@RequestMapping("/contact/update")
	public ModelAndView updateContact(@RequestParam int id, @ModelAttribute Contact employee) {
		employee.setId(id);
		dataService.updateContact(employee);
		return new ModelAndView("redirect:/");
	}
	
	*/

}
