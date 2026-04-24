package thigki2.hanguyentienthinh.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import thigki2.hanguyentienthinh.models.SanPham;
import thigki2.hanguyentienthinh.repositories.SanPhamRepository;
import thigki2.hanguyentienthinh.repositories.TheLoaiRepository;

@Controller
public class WebController {

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private TheLoaiRepository theLoaiRepository;

  
    @GetMapping("/sanpham")
    public String tatCaSanPham(Model model, HttpSession session) {
      
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login"; 
        }

        model.addAttribute("danhSachSP", sanPhamRepository.findAll());
        model.addAttribute("danhSachTheLoai", theLoaiRepository.findAll()); 
        return "danhsach"; 
    }

   
    @GetMapping("/sanpham/theloai/{id}")
    public String sanPhamTheoTheLoai(@PathVariable("id") int id, Model model, HttpSession session) {
        
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login"; 
        }

        model.addAttribute("danhSachSP", sanPhamRepository.findByTheLoaiId(id));
        model.addAttribute("danhSachTheLoai", theLoaiRepository.findAll());
        return "danhsach"; 
    }

   
    @GetMapping("/sanpham/chitiet/{id}")
    public String chiTietSanPham(@PathVariable("id") int id, Model model, HttpSession session) {
       
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login"; 
        }

        SanPham sp = sanPhamRepository.findById(id).orElse(null);
        model.addAttribute("sanPham", sp);
        return "chitiet";
    }
}