import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ceres-test")
public class CeresServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>Defuse the BOM</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2 id=\"message\">This BOM will self destruct in <span id=\"timer\">5</span> seconds...</h2>\n" +
                "<button id=\"defuser\">Defuse the BOM</button>\n" +
                "\n" +
                "<script>\n" +
                "(function() {\n" +
                "    \"use strict\";\n" +
                "\n" +
                "    var detonationTimer = 5;\n" +
                "\n" +
                "    // TODO: This function needs to be called once every second\n" +
                "    function updateTimer() {\n" +
                "        if (detonationTimer == 0) {\n" +
                "            alert('EXTERMINATE!');\n" +
                "            document.body.innerHTML = '';\n" +
                "        } else if (detonationTimer > 0) {\n" +
                "            document.getElementById('timer').innerHTML = detonationTimer;\n" +
                "        }\n" +
                "\n" +
                "        detonationTimer--;\n" +
                "    }\n" +
                "\n" +
                "    var timerInterval = setInterval(updateTimer, 1000);\n" +
                "\n" +
                "    // TODO: When this function runs, it needs to\n" +
                "    // cancel the interval/timeout for updateTimer()\n" +
                "    function defuseTheBOM() {\n" +
                "        clearInterval(timerInterval);\n" +
                "    }\n" +
                "\n" +
                "    // Don't modify anything below this line!\n" +
                "    //\n" +
                "    // This causes the defuseTheBOM() function to be called\n" +
                "    // when the \"defuser\" button is clicked.\n" +
                "    // We will learn about events in the DOM lessons\n" +
                "    var defuser = document.getElementById('defuser');\n" +
                "    defuser.addEventListener('click', defuseTheBOM);\n" +
                "})();\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>");
    }

}
