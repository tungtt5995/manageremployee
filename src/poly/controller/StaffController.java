package poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import poly.dao.StaffDao;
import poly.entity.Departs;
import poly.entity.Staffs;

@Transactional
@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	@Qualifier("StaffDao")
	private StaffDao staffDAO;

	@Autowired
	SessionFactory factory;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showStaff(ModelMap model) {
		List<Staffs> listStaff = staffDAO.listStaffs();
		model.addAttribute("listStaff", listStaff);
		return "staff/staff-list";

	}

	@RequestMapping(value = "/formStaff", method = RequestMethod.GET)
	public String formStaff(ModelMap model) {
		model.addAttribute("staff", new Staffs());
		return "staff/insert-staff";
	}

	@RequestMapping(value = "/staff-insert", method = RequestMethod.POST)
	public String staffInsert(ModelMap model, @ModelAttribute("staff") Staffs staffs,
			@RequestParam("image") MultipartFile image) throws IllegalStateException, IOException {
		System.out.println("Vào insert Staff");
		if (image.isEmpty()) {
			model.addAttribute("message2", "Vui lòng chọn file!");
			return "staff/insert-staff";
		} else {
			String path = context.getRealPath("/assets/img/images_staff" + image.getOriginalFilename());
			staffs.setPhoto(image.getOriginalFilename());
			image.transferTo(new File(path));

			boolean result = staffDAO.addStaff(staffs);
			if (result == true) {
				model.addAttribute("message", "Thêm thành công");
			} else {
				model.addAttribute("message", "Thêm thất bại!");
			}
			return "redirect:/staff/add";
		}

	}

	@SuppressWarnings("unchecked")
	@ModelAttribute("depart")
	public List<Departs> getDeparts() {
		Session session = factory.openSession();
		String hql = "FROM Departs";
		Query query = session.createQuery(hql);
		List<Departs> list = query.list();
		return list;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editStaff(ModelMap model, @PathVariable("id") String id) {
		model.addAttribute("staff", staffDAO.infoStaff(id));
//		model.addAttribute("listStaff", staffDAO.listStaffs());
		return "staff/update-staff";

	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String editStaff(ModelMap model, @PathVariable("id") String id, @ModelAttribute("staff") Staffs staff,
			@RequestParam("image") MultipartFile image) throws IllegalStateException, IOException {
		if (image.isEmpty()) {
			model.addAttribute("message2", "vui lòng chọn file!");
		}else {
			String path = context.getRealPath("/assets/img/images_staff" + image.getOriginalFilename());
			staff.setPhoto(image.getOriginalFilename());
			image.transferTo(new File(path));
			
			staffDAO.editStaff(staff);
			System.out.println("Staff: " + staff);
			model.addAttribute("listStaff", staffDAO.listStaffs());
			System.out.println(id);
			model.addAttribute("message", "Cập nhập thành công");			
		}
		return "redirect:/staff/add";
//		return"staff/update-staff";

	}
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String deleteStaff(ModelMap model, @PathVariable("id") String id) {
		staffDAO.deleteStaff(id);
		//model.addAttribute("listStaff",staffDAO.listStaffs());		
		System.out.println("Deleted");
		return "redirect:/staff/add";
		
	}
}
