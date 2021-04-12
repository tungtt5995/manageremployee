package poly.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dao.DepartDao;
import poly.entity.Departs;

@Transactional
@Controller
@RequestMapping("/depart")
public class DepartController {

	@Autowired
//	@Qualifier("DepartDao")
	private DepartDao departDao;
	@Autowired
	ServletContext context;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showStaff(ModelMap model) {
		List<Departs> listDepart = departDao.listDeparts();
		model.addAttribute("listDepart", listDepart);
		return "depart/depart-list";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(ModelMap model) {
		model.addAttribute("depart", new Departs());
		return ("depart/insert-depart");
	}

	@RequestMapping(value = "/depart-insert", method = RequestMethod.POST)	
	public String insert(ModelMap model,@ModelAttribute("depart") Departs depart) {
		boolean result = departDao.addDepart(depart);
		if (result == true) {
			model.addAttribute("message", "Thêm thành công");
		} else {
			model.addAttribute("message", "Thêm thất bại!");
		}
		return ("depart/insert-depart");
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public  String editDepart(ModelMap model, @PathVariable("id") String id) {
		model.addAttribute("depart", departDao.inforDepart(id));
//		model.addAttribute("listDepart", departDao.listDeparts());
		return "depart/update-depart";
		
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editDepart(ModelMap model, @PathVariable("id") String id, @ModelAttribute("depart") Departs departs) {
		departDao.editDepart(departs);
		model.addAttribute("listDepart", departDao.listDeparts());
		model.addAttribute("message", "Cập nhập thành công");		
		return "depart/update-depart";
	}

}
