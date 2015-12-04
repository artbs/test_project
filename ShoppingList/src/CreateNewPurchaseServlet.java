import inf.info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Zhuk on 18.12.2015.
 */
@WebServlet(name = "CreateNewPurchaseServlet",urlPatterns = "/createnewpurchase")
public class CreateNewPurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Purchase> p = new ArrayList<>();
        int host_id=0;
        try {

            Connection c = DAO.getConnection();
            PreparedStatement ps=c.prepareStatement("SELECT *  FROM purchase");
            ResultSet resultSet=ps.executeQuery("SELECT *  FROM purchase");
            if(resultSet.next()){
                host_id=resultSet.getInt(5);
            }
            int id= DAO.addPurchase(new Purchase(0,request.getParameter("name"),request.getParameter("count"),false),host_id);


            DAO.updateListPurchase(id,host_id);
            info.setValue(1);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/showlist?id="+Integer.toString(host_id));

    }

}
