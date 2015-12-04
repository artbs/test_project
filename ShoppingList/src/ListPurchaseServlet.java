import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Zhuk on 18.12.2015.
 */
@WebServlet(name = "ListPurchaseServlet",urlPatterns = "/showlist")
public class ListPurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (User user : User.Users) {
            if(user.connection_host.equals(request.getRemoteHost()))
            {
                ArrayList<Purchase> l= null;
                try {
                    l = DAO.getListPurchases(Integer.parseInt(request.getParameter("id")));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                request.setAttribute("Purchaselists",l);


                break;
            }
        }
        request.getRequestDispatcher("purchase_table.jsp"). forward(request, response);
    }
}
