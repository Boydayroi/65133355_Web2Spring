package thigki2.hanguyentienthinh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thigki2.hanguyentienthinh.models.SanPham;
import thigki2.hanguyentienthinh.models.TheLoai;
import thigki2.hanguyentienthinh.repositories.SanPhamRepository;
import thigki2.hanguyentienthinh.repositories.TheLoaiRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private TheLoaiRepository theLoaiRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    // 1. API Lấy danh sách các thể loại sản phẩm
    @GetMapping("/theloai")
    public List<TheLoai> layDanhSachTheLoai() {
        return theLoaiRepository.findAll();
    }

    // 2. API Lấy danh sách sản phẩm theo một thể loại (truyền id thể loại)
    @GetMapping("/sanpham/theloai/{id}")
    public List<SanPham> laySanPhamTheoTheLoai(@PathVariable("id") int theLoaiId) {
        // Gọi hàm findByTheLoaiId mà chúng ta đã khai báo trong SanPhamRepository
        return sanPhamRepository.findByTheLoaiId(theLoaiId);
    }
}
