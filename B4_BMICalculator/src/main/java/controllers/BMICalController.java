package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BMICalController {
	@GetMapping("/")
	public String nhapBMI() {
		return "form";
	}
	@PostMapping("/")
	public String tinhBMI(HttpServletRequest thamso ,ModelMap m) {
		String weight = thamso.getParameter("w");
		String height = thamso.getParameter("h");
		
		double w = Double.parseDouble(weight);
		double h = Double.parseDouble(height);
		
		double kq = w / (h * h);
		
		m.addAttribute("w", w);
		m.addAttribute("h", h);
		m.addAttribute("kq", String.format("%.2f", kq));
		
		return "calbmi";
	}
}
