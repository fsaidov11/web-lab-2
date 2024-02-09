package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
    private final List<Double> rValues = Arrays.asList(1.0, 1.5, 2.0, 2.5, 3.0);

    // Переопределение запросов

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Utils.getDoubleParameter(request, "x");
            Utils.getDoubleParameter(request, "y");
            double r = Utils.getDoubleParameter(request, "r");

            if (!rValues.contains(r))
                throw new Exception("Неправильный радиус (R)!!!");
            getServletContext().getRequestDispatcher("/area_check").forward(request, response);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}