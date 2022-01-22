package controller.boardcontroller;

import controller.MyModelAndView;
import controller.ViewResolver;
import service.BoardService;
import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "boardDeleteController", urlPatterns = "/board/delete")
public class BoardDeleteController extends HttpServlet {

    BoardService boardService = new BoardService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Map<String, String> paramMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();

        createParamMap(req, paramMap);

        String viewName = boardService.delete(paramMap, model);

        MyModelAndView view = ViewResolver.resolve(viewName);

        view.render(req, resp, model);
    }

    private void createParamMap(HttpServletRequest req, Map<String, String> paramMap) {
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
    }

}