import inf.info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by Zhuk on 18.12.2015.
 */
@WebServlet(name = "DeleteListsServlet",urlPatterns = "/deletelist")
public class DeleteListsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        info.setValue(0);
        final Map<String, String[]> parameterMap = request.getParameterMap();
        final Collection<String[]> values = parameterMap.values();
        final Enumeration<String> parameterNames = request.getParameterNames();
        String ptr;

        for (String[] value: values) {
            for (String val: value){
            for (User user : User.Users) {
                if (user.connection_host.equals(request.getRemoteHost())) {
                    try {
                        DAO.deleteList(Integer.parseInt(val), user);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            }
        }
        response.sendRedirect("/mylists");
    }
}
