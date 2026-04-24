package thigki2.hanguyentienthinh.controllers;

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

    // Tính năng 1: Hiển thị Tất cả sản phẩm
    @GetMapping("/sanpham")
    public String tatCaSanPham(Model model) {
        model.addAttribute("danhSachSP", sanPhamRepository.findAll());
        model.addAttribute("danhSachTheLoai", theLoaiRepository.findAll()); // Truyền thêm để làm menu lọc
        return "danhsach"; 
    }

    // Tính năng 2: Hiển thị Sản phẩm theo mã thể loại
    @GetMapping("/sanpham/theloai/{id}")
    public String sanPhamTheoTheLoai(@PathVariable("id") int id, Model model) {
        model.addAttribute("danhSachSP", sanPhamRepository.findByTheLoaiId(id));
        model.addAttribute("danhSachTheLoai", theLoaiRepository.findAll());
        return "danhsach"; 
    }

    // Tính năng 3: Hiển thị Chi tiết một sản phẩm
    @GetMapping("/sanpham/chitiet/{id}")
    public String chiTietSanPham(@PathVariable("id") int id, Model model) {
        SanPham sp = sanPhamRepository.findById(id).orElse(null);
        model.addAttribute("sanPham", sp);
        return "chitiet";
    }
}