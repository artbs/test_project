import inf.info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zhuk on 18.12.2015.
 */
@WebServlet(name = "NewPurchaseServlet",urlPatterns = "/newpurchase")
public class NewPurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        info.setValue(0);
        request.getRequestDispatcher("newpurchase.jsp"). forward(request, response);
    }
}
