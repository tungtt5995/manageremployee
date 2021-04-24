package poly.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poly.dao.UserDao;
import poly.entity.Users;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	SessionFactory factory;

	@Autowired
	private UserDao userDao;

	@RequestMapping("/form")
	public String login(ModelMap model) {
		model.addAttribute("auth", new Users());
		return "login/login";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String loginSubmit(ModelMap model, @RequestParam("username") String username,
			@RequestParam("password") String password, @ModelAttribute("auth") Users auth, BindingResult errors) {

		if (auth.getUsername().trim() == "") {
			errors.rejectValue("username", "auth", "Empty Username");
		}
		if (auth.getPassword().trim() == "") {
			errors.rejectValue("password", "auth", "Empty Password");
		}

		if (errors.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			return "login/login";
		} else {
			Users user = userDao.login(auth.getUsername(), password);
			if (user != null) {
				model.addAttribute("message", "Chúc mừng, bạn đã nhập đúng !");
				return "redirect:/staff/add";
			} else {
				return "login/login";
			}

		}
	}
}
