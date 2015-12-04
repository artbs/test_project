import inf.info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by Zhuk on 17.12.2015.
 */
@WebServlet(name = "CreateNewListServlet",urlPatterns = "/createnewlist")
public class CreateNewListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        info.setValue(0);
        // request.getRequestDispatcher("newlist.jsp"). forward(request, response);
        ArrayList<Purchase> p = new ArrayList<>();

        try {
            int id=DAO.addList(new PurchaseList(0,request.getParameter("name"),request.getParameter("comments"),p));
            for (User user : User.Users) {
               if(user.connection_host.equals(request.getRemoteHost()))
                {
                    DAO.updateUserLists(id,user);
                    info.setValue(1);
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/menu");


    }



}
