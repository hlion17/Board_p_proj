package controller.boardcontroller;

import controller.MyModelAndView;
import controller.ViewResolver;
import model.Board;
import repository.BoardRepository;
import repository.MybatisBoardRepository;
import service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "boardListController", urlPatterns = "/board/list")
public class BoardPageListController extends HttpServlet {

    BoardService boardService = new BoardService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Map<String, String> paramMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();

        createParamMap(req, paramMap);

        // 게시글 수 제한(미완성)
        // pageSize
        // session으로 처리하는게 맞는지는 의문
//        if (paramMap.get("pageSize") != null) {
//            String pageSize = paramMap.get("pageSize");
//            req.getSession().setAttribute("pageSize", pageSize);
//        }
//
//        if (req.getSession().getAttribute("pageSize") != null) {
//            String pageSize = (String)req.getSession().getAttribute("pageSize");
//            paramMap.put("pageSize", pageSize);
//        }

        String viewName = boardService.getPageList(paramMap, model);

        MyModelAndView view = ViewResolver.resolve(viewName);

        view.render(req, resp, model);
    }

    private void createParamMap(HttpServletRequest req, Map<String, String> paramMap) {
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
    }
}
