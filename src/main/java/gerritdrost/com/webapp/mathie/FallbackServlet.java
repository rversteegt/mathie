package gerritdrost.com.webapp.mathie;

import org.jtwig.web.servlet.JtwigRenderer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class FallbackServlet extends HttpServlet {
    private final JtwigRenderer renderer = JtwigRenderer.defaultRenderer();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index").forward(request, response);
    }
}
