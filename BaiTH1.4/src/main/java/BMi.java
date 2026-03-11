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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter traVe = response.getWriter();

        traVe.append("<h3>Tính chỉ số BMi (GET)</h3>");

        String actionURL = request.getContextPath() + "/BMi";
        String noiDungHTML = "<form method='POST' action='" + actionURL + "'>"
                + "   <label>Chiều cao (m): </label>"
                + "   <input type='text' name='height' placeholder='VD: 1.70' required><br><br>"
                + "   <label>Cân nặng (kg): </label>"
                + "   <input type='text' name='weight' placeholder='VD: 65' required><br><br>"
                + "   <input type='submit' value='Tính Toán'>"
                + "</form>";

        traVe.append(noiDungHTML);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter traVe = response.getWriter();
        
        try {
            String hStr = request.getParameter("height");
            String wStr = request.getParameter("weight");
            
            double h = Double.parseDouble(hStr);
            double w = Double.parseDouble(wStr);
            double bmi = w / (h * h);

          
            String phanLoai = "";
            if (bmi < 18.5) {
                phanLoai = "Gầy - Nên ăn nhiều hơn nhé!";
            } else if (bmi < 24.9) {
                phanLoai = "Bình thường - Chúc mừng bạn!";
            } else if (bmi < 29.9) {
                phanLoai = "Thừa cân - Nên tập thể dục thêm.";
            } else {
                phanLoai = "Béo phì - Cần chế độ ăn kiêng.";
            }
         

            traVe.append("<h3>Kết quả BMi (POST)</h3>");
            traVe.append("<p>Chiều cao: " + h + " m</p>");
            traVe.append("<p>Cân nặng: " + w + " kg</p>");
            traVe.append("<p><b>Chỉ số: " + String.format("%.2f", bmi) + "</b></p>");
            
          
            traVe.append("<p>Phân loại: <b style='color: red;'>" + phanLoai + "</b></p>");
            
            String backLink = request.getContextPath() + "/BMi";
            traVe.append("<br><a href='" + backLink + "'>Tính lại</a>");

        } catch (Exception e) {
            traVe.append("<h3>Lỗi nhập liệu! Vui lòng nhập số.</h3>");
            String backLink = request.getContextPath() + "/BMi";
            traVe.append("<a href='" + backLink + "'>Quay lại</a>");
        }
    }
}