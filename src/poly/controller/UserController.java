package poly.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String insertUser(ModelMap model, @Validated @ModelAttribute("user") Users users, BindingResult error ) {
		if(error.hasErrors()) {
			model.addAttribute("message1", "Vui lòng kiểm tra lại thông tin!");
		}		
		boolean result = userDao.addUser(users);
		if (result == true) {
			model.addAttribute("message", "Thêm thành công");
		} else {
			model.addAttribute("message", "Thêm thất bại!");
		}
		return "user/insert-user";
	}

	@RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
	public String deleteUser(ModelMap model, @PathVariable("username") String username) {
		userDao.deleteUser(username);
//		System.out.println("Deleted");
		return "redirect:/user/add";

	}

	@RequestMapping(value = "/edit/{username}", method = RequestMethod.GET)
	public String formEdit(ModelMap model, @PathVariable("username") String username) {
		model.addAttribute("user", userDao.inforUser(username));
		return "user/edit-user";

	}

	@RequestMapping(value = "/edit/{username}", method = RequestMethod.POST)
	public String editUser(ModelMap model, @PathVariable("username") String username,
			@ModelAttribute("user") Users users) {
	System.out.println("user" + users.getUsername());
		userDao.editUser(users);
		model.addAttribute("message", "Cập nhập thành công");
		return "user/edit-user";

	}

}
