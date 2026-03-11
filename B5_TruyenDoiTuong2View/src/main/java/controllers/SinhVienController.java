package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SinhVienController {
	@GetMapping("/")
	public String showSinhVien(ModelMap m) {
		SinhVien sv1 = new SinhVien("65133355","ha Nguyen Tien Thinh","2005","Nam");
		m.addAttribute("sv",sv1);
		//return "detail";
		return "detail-2";
	}
}