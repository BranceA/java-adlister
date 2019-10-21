import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/count")
public class CountServlet extends HttpServlet {

    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        hitCount++;
        PrintWriter out = res.getWriter();
        String reset = req.getParameter("reset");
        if(reset != null){
            init();
            res.sendRedirect("http://localhost:8080/count");
        }
//        String title = "Total Number of Hits";
//        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Count Page</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
                "    <style>\n" +
                "        .card{\n" +
                "            margin-right: 25%;\n" +
                "            margin-left: 25%;\n" +
                "        }\n" +
                "        button {\n" +
                "            margin-top: 1em;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body class=\"bg-light\">\n" +
                "<h1 align =\"center\">WELCOME TO THE COUNT PAGE!!!!</h1>\n" +
                "\n" +
                "<h2 align =\"center\">CHECK IT OUT!!!</h2>\n" +
                "<h3 align =\"center\">This is how many times someone has been here.</h3>\n" +
                "<div class=\"card\">\n" +
                "    <h2 align =\"center\" id=\"hit-count\" >" + hitCount + "</h2>\n" +
                "</div>\n" +
                "<div class=\"text-center\">\n" +
                "    <button id=\"reset-btn\">RESET!!!</button>\n" +
                "</div>\n" +
                "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n" +
                "<script>\n" +
                "    \n" +
                "    $(\"#reset-btn\").click(function () {\n" +
                "        location.replace(\"http://localhost:8080/count?reset=reset\");\n" +
                "    })\n" +
                "    \n" +
                "</script>\n" +
                "</body>\n" +
                "</html>");
    }
}
