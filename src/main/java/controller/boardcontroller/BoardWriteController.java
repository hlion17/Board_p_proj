package controller.boardcontroller;

import controller.MyModelAndView;
import controller.ViewResolver;
import service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "boardWriteController", urlPatterns = "/board/write")
public class BoardWriteController extends HttpServlet {

    BoardService boardService = new BoardService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Map<String, String> paramMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();

        createParamMap(req, paramMap);

        if (req.getSession().getAttribute("loginId") != null) {
            String loginId = (String)req.getSession().getAttribute("loginId");
            paramMap.put("memberId", loginId);
        }

        String viewName = boardService.write(paramMap, model);

        MyModelAndView mv = ViewResolver.resolve(viewName);
        mv.render(req, resp, model);  // board-result

    }

    private void createParamMap(HttpServletRequest req, Map<String, String> paramMap) {
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
    }
}
