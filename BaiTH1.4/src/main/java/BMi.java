import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BMi")
public class BMi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BMi() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter traVe = response.getWriter();

		traVe.append("<h3>Chương trình tính chỉ số BMI (GET)</h3>");

		
		String actionURL = request.getContextPath() + "/BMI";

		String noiDungHTML = "<form method='POST' action='" + actionURL + "'>"
				+ "   <label>Chiều cao (m): </label>"
				+ "   <input type='text' name='height' placeholder='Ví dụ: 1.70' required><br><br>"
				+ "   <label>Cân nặng (kg): </label>"
				+ "   <input type='text' name='weight' placeholder='Ví dụ: 65' required><br><br>"
				+ "   <input type='submit' value='Tính Toán'>"
				+ "</form>";

		traVe.append(noiDungHTML);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter traVe = response.getWriter();

		try {
			
			String heightStr = request.getParameter("height");
			String weightStr = request.getParameter("weight");

			
			double h = Double.parseDouble(heightStr);
			double w = Double.parseDouble(weightStr);

			
			double bmi = w / (h * h);

			
			String phanLoai = "";
			if (bmi < 18.5) phanLoai = "Gầy";
			else if (bmi < 24.9) phanLoai = "Bình thường";
			else if (bmi < 29.9) phanLoai = "Thừa cân";
			else phanLoai = "Béo phì";

			
			traVe.append("<h3>Kết quả tính toán (POST)</h3>");
			traVe.append("<p>Chiều cao: " + h + " m</p>");
			traVe.append("<p>Cân nặng: " + w + " kg</p>");
		
			traVe.append("<p><b>Chỉ số BMI: " + String.format("%.2f", bmi) + "</b></p>");
			traVe.append("<p>Phân loại: <span style='color:blue; font-weight:bold'>" + phanLoai + "</span></p>");

			
			String backLink = request.getContextPath() + "/BMI";
			traVe.append("<br><a href='" + backLink + "'>Tính lại</a>");

		} catch (NumberFormatException e) {
			traVe.append("<h3>Lỗi: Vui lòng nhập đúng định dạng số!</h3>");
			String backLink = request.getContextPath() + "/BMI";
			traVe.append("<a href='" + backLink + "'>Thử lại</a>");
		}
	}
}