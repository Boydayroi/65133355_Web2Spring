package baitap._5.ntuhanguyentienthinh.demoBaoMatCoBan.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
@GetMapping("/")
public String index() {
	return "index";
}
}
