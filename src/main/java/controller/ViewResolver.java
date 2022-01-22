package controller;

public class ViewResolver {
    static public MyModelAndView resolve(String viewName) {

        try {
            if (viewName.substring(0, 9).equals("redirect:")) {
                return new MyModelAndView(viewName.substring(9));
            } else {
                return new MyModelAndView("/views/" + viewName + ".jsp");
            }
        } catch (StringIndexOutOfBoundsException e) {
            return new MyModelAndView("/views/" + viewName + ".jsp");
        }
    }
}
