package controller.CommentController;

import controller.MyModelAndView;
import controller.ViewResolver;
import service.CommentService;
import service.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "WriteCommentController", urlPatterns = "/comment/write")
public class WriteCommentController extends HttpServlet {

    CommentService commentService = new CommentServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // request 객체 인코딩 설정
        req.setCharacterEncoding("UTF-8");

        // request parameter 의 정보를 Map 으로 옮겨 담기
        // 데이터를 전달할 model 정의
        Map<String, String> paramMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();
        creatParamMap(req, paramMap);

        // 댓글 서비스 호출하고 결과를 랜더링 할 페이지 이름 받아오기
        String viewName = commentService.write(paramMap, model);

        // 랜더링할 페이지 경로 완성
        // 보내줄 요청 데이터 완성 model -> request
        MyModelAndView view = ViewResolver.resolve(viewName);

        // 새로고침 시 댓글이 두 번 작성되는 것을 막기 위해서 /board/post 로 redirect
        view.redirect(resp);
    }

    private void creatParamMap(HttpServletRequest req, Map<String, String> paramMap) {
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
    }
}
