package controller.membercontroller;

import controller.MyModelAndView;
import controller.ViewResolver;
import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "memberEditController", urlPatterns = "/member/edit")
public class MemberEditController extends HttpServlet {

    MemberService memberService = new MemberService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        Map<String, String> paramMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();

        createParam(req, paramMap);

        String viewName = memberService.edit(paramMap, model);

        MyModelAndView view = ViewResolver.resolve(viewName);
        view.render(req, resp, model);
    }

    private void createParam(HttpServletRequest req, Map<String, String> paramMap) {
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
    }

}
