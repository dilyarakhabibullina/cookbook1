package ru.itpark.servlet;

import ru.itpark.domain.Recipe;
import ru.itpark.service.CookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CookServlet extends HttpServlet {
    CookService service = new CookService();
//    private final List<Recipe> items = new ArrayList<>();
//
//    // Не совсем правильно
//    public CookServlet() {
//
//        //items.addAll(service.getHouses());
//       items.add(new Recipe ("1","borwer","svek","tasty"));
//       items.add(new Recipe ("1","meat","lamb","not tasty"));
//
//    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String url = req.getRequestURI().substring(req.getContextPath().length());
        System.out.println(url);

        if (url.equals("/")) {
            resp.getWriter().write("ok");
            return;
        }

        if (url.equals("/search")) {
            if (req.getMethod().equals("GET")) {
                List<Recipe> items = null;
                try {
                    items = service.getAll();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // resp.getWriter().write(service.getHouses().toString());nullpointer exception

                req.setAttribute("items", items);
                               req.getRequestDispatcher("/WEB-INF/search.jsp").forward(req, resp);
                return;
            }
        }
    }
}
