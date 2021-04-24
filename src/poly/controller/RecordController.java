package poly.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dao.RecordDAO;
import poly.entity.Records;
import poly.entity.Staffs;

@Controller
@RequestMapping("/record")
public class RecordController {
	@Autowired
	@Qualifier("RecordDAO")
	private RecordDAO recordDAO;
	@Autowired
	SessionFactory factory;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showRecord(ModelMap model) {
		List<Record> listRecord = recordDAO.listRecord();
		model.addAttribute("listrecord", listRecord);
		return "record/record-list";

	}

	@RequestMapping(value = "/formRecord", method = RequestMethod.GET)
	public String formRecord(ModelMap model) {
		model.addAttribute("record", new Records());
		return "record/insert-record";
	}

	@RequestMapping(value = "/insert-Record", method = RequestMethod.POST)
	public String insertRecord(ModelMap model,@Validated @ModelAttribute("record") Records records,BindingResult erros) {
		if(erros.hasErrors()) {
			model.addAttribute("message1", "Kiểm tra lại thông tin nhập");
		}		
		boolean result = recordDAO.insertRecord(records);
		if (result == true) {
			model.addAttribute("message", "Thêm thành công");
		} else {
			model.addAttribute("message", "Thêm thất bại!");
		}
		return "record/insert-record";
//		return "redirect:/record/add";

	}

	@ModelAttribute("staffs")
	public List<Staffs> getStaffs() {
		Session session = factory.openSession();
		String hql = "FROM Staffs";
		Query query = session.createQuery(hql);
		List<Staffs> list = query.list();
		return list;
	}
}
