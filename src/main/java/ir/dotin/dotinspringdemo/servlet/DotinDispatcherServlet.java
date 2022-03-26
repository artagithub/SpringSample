package ir.dotin.dotinspringdemo.servlet;

import ir.dotin.dotinspringdemo.account.Card;
import ir.dotin.dotinspringdemo.controller.CardController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/aaa")
public class DotinDispatcherServlet extends HttpServlet implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private HashMap controllers = new HashMap();


    @Override
    public void init() throws ServletException {
        if(applicationContext!=null){
            applicationContext.getBeansWithAnnotation(RestController.class).forEach((s, o) ->
            {
                RestController annotation = AnnotationUtils.getAnnotation(o.getClass(), RestController.class);
                if (annotation != null) {
                    if(annotation.value()!=null){
                        controllers.put(annotation.value(),o);
                    }
                }

            });
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().contains("card")){
            CardController cardController = (CardController) controllers.get("cardController");
            if(req.getRequestURI().contains("find")){
                Card card = cardController.findCard(Integer.valueOf(req.getParameter("cardId")));
                System.out.println(card.getPanNumber());

                PrintWriter out = resp.getWriter();
                out.println("<html>");
                out.println("<body>"
                        + "<h2>Card pan number is : "+ card.getPanNumber() +"<h2>"
                        +"</body>");
                out.println("</html>");
            }
        }
//        super.doGet(req, resp);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
