package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import services.TinTucService;

@Controller
public class HomeController {

    @Autowired
    private TinTucService tinTucService;

  
    @GetMapping("/")
    public String trangChu(ModelMap model) {
   
        var danhSachTin = tinTucService.layTatCaTinTuc();
        
    
        model.addAttribute("dsTinTuc", danhSachTin);
        
        
        return "index";
    }
}
