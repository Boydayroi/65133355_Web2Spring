package baitap._5.ntuhanguyentienthinh.demoBaoMatCoBan.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
@GetMapping("/")
public String index() {
	return "index";
}
@GetMapping("/products/")
public String index1() {
	return "sanpham";
}
@GetMapping("/admincp")
public String index2() {
	return "indexadmin";
}
@GetMapping("/hello")
public String hi() {
	return "hello";
}

}

