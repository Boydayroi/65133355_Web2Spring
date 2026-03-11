package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SinhVienController {
	//TruyenDuLieuSangView
	//truyền dữ liệu: MSSV, Họ tên SV, Năm sinh, Giới tính
	@GetMapping("/")
	public String SinhVien(ModelMap m) {
		String name = "ha Nguyen Tien Thinh";
		String mssv = "65133355";
		String ns = "2005";
		String gtinh = "Nam";
		m.addAttribute("name", name);
		m.addAttribute("mssv", mssv);
		m.addAttribute("ns", ns);
		m.addAttribute("gt", gtinh);
		return "sinhvien";
	}
}
