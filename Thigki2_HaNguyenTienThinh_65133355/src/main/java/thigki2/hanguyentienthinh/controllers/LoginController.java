package thigki2.hanguyentienthinh.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thigki2.hanguyentienthinh.models.NguoiDung;
import thigki2.hanguyentienthinh.repositories.NguoiDungRepository;

@Controller
public class LoginController {

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    // 1. Hiển thị form đăng nhập
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // 2. Xử lý khi người dùng bấm nút Đăng nhập
    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) {
        
        // Dùng hàm đã viết sẵn trong Repository để tìm user trong DB
        NguoiDung user = nguoiDungRepository.findByUsernameAndPassword(username, password);
        
        if (user != null) {
            // Nếu đúng tài khoản: Lưu vào phiên làm việc (session) và chuyển tới trang sản phẩm
            session.setAttribute("loggedInUser", user);
            return "redirect:/sanpham"; 
        } else {
            // Nếu sai: Báo lỗi và bắt đăng nhập lại
            model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu!");
            return "login";
        }
    }
    
    // 3. Xử lý Đăng xuất
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser"); // Xóa thông tin đăng nhập
        return "redirect:/login";
    }
}