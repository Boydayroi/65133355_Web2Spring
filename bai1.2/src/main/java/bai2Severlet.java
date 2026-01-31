import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Tên Class bắt buộc phải là bai2Severlet (trùng với tên file của bạn)
@WebServlet("/testDoPost")
public class bai2Severlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bai2Severlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter traVe = response.getWriter();
		
		traVe.append("<h3>Bạn vừa gửi Yêu cầu dạng GET, đây là đáp ứng của tôi</h3>");
		
		String actionURL = request.getContextPath() + "/testDoPost";
		
		String noiDungHTML = "<form method='POST' action='" + actionURL + "'>" 
				+ "				<label> Họ:</label>"
				+ " 			<input type='text' name='fname' ><br>"
				+ " 			<label> Tên:</label>"
				+ " 			<input type='text' name='lname' ><br>"
				+ " 			<input type='submit' value='Gửi đi'>"
				+ "</form>";
		
		traVe.append(noiDungHTML);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String value1 = request.getParameter("fname"); 
		String value2 = request.getParameter("lname"); 
		
		PrintWriter traVe = response.getWriter();
		traVe.append("<h3>Bạn vừa gửi Yêu cầu dạng POST, đây là đáp ứng của tôi</h3>");
		traVe.append("<p>Giá trị tham số fname = " + value1 + "</p>");
		traVe.append("<p>Giá trị tham số lname = " + value2 + "</p>");	
	}
}