import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AboutMe")
public class AboutMe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AboutMe() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter traVe = response.getWriter();
        
        
        String css = "<style>"
                + "body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; padding-top: 50px; }"
                + ".card { background: white; width: 300px; margin: auto; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }"
                + "h2 { color: #333; }"
                + "</style>";

        traVe.append(css);
        traVe.append("<h3>Đây là đáp ứng cho yêu cầu AboutMe (GET)</h3>");

        String noiDungHTML = "<div class='card'>"
                + "    <h2>Thông Tin Cá Nhân</h2>"
                + "    <p><b>Họ và tên:</b> Hà Nguyễn Tiến Thịnh </p>" 
                + "    <p><b>MSSV:</b> 65133355</p>"
                + "    <p><b>Lớp:</b> Công nghệ thông tin</p>"
                + "    <p><b>Email:</b> email@st.ntu.edu.vn</p>"
                + "</div>";
        
        traVe.append(noiDungHTML);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        doGet(request, response);
    }
}