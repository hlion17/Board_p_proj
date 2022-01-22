package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// url / 로 설계한거 잘못됬음
// 모든 잘못된 요청이 home으로 옴
@WebServlet(name = "homeController", urlPatterns = {"/", "/home"})
public class HomeController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Map<String, String> paramMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();

        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));

        String viewName = "home";

        MyModelAndView mv = ViewResolver.resolve(viewName);
        mv.render(req, resp, model);


    }

}
