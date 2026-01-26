import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter; // Cần thêm thư viện này để in ra màn hình

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Hello() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Cấu hình để hiển thị tiếng Việt không bị lỗi font (Rất quan trọng)
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 2. Chuẩn bị nội dung HTML (Theo hình ảnh bạn gửi trước đó)
		String noiDungHTML = "<center><h3>TÔI HỌC WEB JAVA</h3></center>";
		noiDungHTML += "<hr>";
		noiDungHTML += "<b>Lớp:</b> 65CNTTCLC <br>";
		noiDungHTML += "<b>MSSV:</b> 65133355"; // Mình thêm MSSV của bạn vào luôn cho đầy đủ
		
		// 3. Gửi phản hồi về trình duyệt
		PrintWriter boTraLoi = response.getWriter();
		boTraLoi.print(noiDungHTML);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}