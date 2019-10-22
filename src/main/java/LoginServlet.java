import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("username") != null && request.getParameter("password") != null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("password")) {
                response.sendRedirect("/profile");
            }
        }
    }
}