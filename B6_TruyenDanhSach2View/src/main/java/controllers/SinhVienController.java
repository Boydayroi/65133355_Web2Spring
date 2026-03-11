package controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SinhVienController {
	@GetMapping("/")
	public String listSinhVien(ModelMap m) {
		List<SinhVien> ds = Arrays.asList(
			new SinhVien("65133355","ha Nguyen Tien Thinh","2005","Nam"),
			new SinhVien("65131508","Cai Tran Dang Khoi","2005","Nam"),
			new SinhVien("65138315","Tran Thao Thanh Vy","2005","Nam")
				);
		m.addAttribute("sinhviens",ds);
		return "danhsach";
	}
}
