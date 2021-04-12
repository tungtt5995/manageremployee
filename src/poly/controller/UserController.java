package poly.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dao.UserDao;
import poly.entity.Users;

@Controller
@Transactional
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showUser(ModelMap model) {
		List<Users> listUsers = userDao.listUses();
		model.addAttribute("listUser", listUsers);
		return "user/user-list";

	}

	@RequestMapping(value = "/formUser", method = RequestMethod.GET)
	public String formUser(ModelMap model) {
		model.addAttribute("user", new Users());
		return "user/insert-user";
	}

	@RequestMapping(value = "/user-insert", method = RequestMethod.POST)
	public String insertUser(ModelMap model, @ModelAttribute("user") Users users) {
		boolean result = userDao.addUser(users);
		if (result == true) {
			model.addAttribute("message", "Thêm thành công");
		} else {
			model.addAttribute("message", "Thêm thất bại!");
		}
		return "user/insert-user";
	}

	
}
