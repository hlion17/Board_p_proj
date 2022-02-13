package controller;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Getter @Setter
public class MyModelAndView {

    private String viewName;
    private Map<String, Object> model;

    public MyModelAndView(String viewName) {
        this.viewName = viewName;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
        dispatcher.forward(request, response);
    }

    public void render(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws ServletException, IOException {
        modelToRequestAttribute(request, model);

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
        dispatcher.forward(request, response);
    }

    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect(viewName);
    }

    private void modelToRequestAttribute(HttpServletRequest request, Map<String, Object> model) {
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
}
