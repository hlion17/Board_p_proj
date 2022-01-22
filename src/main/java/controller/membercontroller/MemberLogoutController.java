package controller.membercontroller;

import controller.MyModelAndView;
import service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "memberLogoutController", urlPatterns = "/member/logout")
public class MemberLogoutController extends HttpServlet {

    private MemberService memberService = new MemberService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

//        Map<String, String> paramMap = new HashMap<>();
//        Map<String, Object> model = new HashMap<>();
//
//        createParamMap(req, paramMap);

//        String viewName = memberService.logout(paramMap, model);

        MyModelAndView view = viewResolver("home");

//        view.render(req, resp, model);

        // 세션 로그아웃 처리
        req.getSession().invalidate();

        view.render(req, resp);
    }

    private void createParamMap(HttpServletRequest req, Map<String, String> paramMap) {
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
    }

    private MyModelAndView viewResolver(String viewName) {
        return new MyModelAndView("/views/" + viewName + ".jsp");
    }
}
