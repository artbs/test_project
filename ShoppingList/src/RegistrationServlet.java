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
@WebServlet(name = "RegistrationServlet",urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        info.setValue(0);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<PurchaseList> list = new ArrayList<>();
        try {

            if(request.getParameter("passwordsignup_confirm").equals(request.getParameter("passwordsignup"))) {
                if(DAO.addUser(new User(0, request.getParameter("usernamesignup"), request.getParameter("passwordsignup"), list, users,request.getRemoteHost())))
                    response.getOutputStream().write( ("Success!").getBytes());
                else{
                    info.setValue(2);
                    response.sendRedirect("index");
                }
            }

            else{
                info.setValue(2);
                response.sendRedirect("index");
            }



        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }
}
