import inf.info;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Zhuk on 16.12.2015.
 */
@javax.servlet.annotation.WebServlet(name = "AuthorizationServlet",urlPatterns = "/authorization")
public class AuthorizationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        info.setValue(0);
        ArrayList<User> users = new ArrayList<>();
        ArrayList<PurchaseList> list = new ArrayList<>();
        try {
            User user=new User(0, request.getParameter("username"), request.getParameter("password"), list, users,request.getRemoteHost());
            if(DAO.checkUser(user)) {
                user.setOnline(true);
                User.Users.add(user);
                response.sendRedirect("menu");
            }
            else{
                info.setValue(2);
                response.sendRedirect("index");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
