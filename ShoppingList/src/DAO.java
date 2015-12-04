import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhuk on 17.12.2015.
 */
public class DAO {//stored proceduresd, separate user with rights to execute sps. //ORM
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "artbs", "zhuk");

    }

    public static List<User> getUsers() throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement("SELECT id, txt from users");

        ResultSet resultSet = ps.executeQuery("SELECT id, txt from users");

        ArrayList<User> users = new ArrayList<>();

       /*/ while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String txt = resultSet.getString(2);
            posts.add(new Post(id, txt));
        }/*/

        return users;
    }


    public static void deleteUser(int id) {

    }

    public static boolean addUser(User user) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        Statement stmt;
        stmt=c.createStatement();
        PreparedStatement ps=c.prepareStatement("SELECT *  FROM users where name='"+user.name+"'");
        ResultSet resultSet=ps.executeQuery("SELECT *  FROM users where name='"+user.name+"'");
       if(resultSet.next())
            return false;
        String sql = "SELECT *  FROM users where name='"+user.name+"'";
       sql = "INSERT INTO users(name,password) " + "VALUES('" + user.name + "','"+ user.password + "')";
        stmt.executeUpdate(sql);

        ps=c.prepareStatement("SELECT *  FROM users where name='"+user.name+"'");
         resultSet=ps.executeQuery("SELECT *  FROM users where name='"+user.name+"'");
        if(resultSet.next()){
            user.id=resultSet.getInt(0);
        }
        else
            return false;

        return true;
    }

    public static boolean checkUser(User user) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        PreparedStatement ps=c.prepareStatement("SELECT *  FROM users where name='"+user.name+"'");
        ResultSet resultSet=ps.executeQuery("SELECT *  FROM users where name='"+user.name+"'");
        if(resultSet.next()){
            if((resultSet.getString(3)).equals(user.password))
                return true;
        }
        return false;
    }



    public static int addList(PurchaseList list) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        Statement stmt;
        stmt=c.createStatement();
        String sql = "SELECT *  FROM users where name='"+list+"'";
        sql = "INSERT INTO lists(name,comments) " + "VALUES('" + list.name + "','"+ list.comments + "')";
        stmt.executeUpdate(sql);
        PreparedStatement ps=c.prepareStatement("SELECT *  FROM lists where name='"+list.name+"'");
        ResultSet resultSet=ps.executeQuery("SELECT *  FROM lists where name='"+list.name+"'");
        int id=0;
        while(resultSet.next()){
            id=resultSet.getInt(1);
        }

        list.id=id;
        return id;
    }

    public static boolean updateUserLists(int id,User user) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        PreparedStatement ps=c.prepareStatement("SELECT *  FROM users where name='"+user.name+"'");
        ResultSet resultSet=ps.executeQuery("SELECT *  FROM users where name='"+user.name+"'");
        String string_lists=new String();
        if(resultSet.next()){
            string_lists=resultSet.getString(4);
        }
        else
            return false;

        if(string_lists==null){
            string_lists=new String();
            string_lists=string_lists+Integer.toString(id)+",";
        }
        else{
            string_lists=string_lists+Integer.toString(id)+",";
        }

        Statement stmt;
        stmt=c.createStatement();
        String sql = "UPDATE users set lists='"+string_lists+"' where name='" +user.name+"'";
        stmt.executeUpdate(sql);

        return true;
    }


    public static ArrayList<PurchaseList> getUserLists(User user) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        PreparedStatement ps=c.prepareStatement("SELECT *  FROM users where name='"+user.name+"'");
        ResultSet resultSet=ps.executeQuery("SELECT *  FROM users where name='"+user.name+"'");

        String string_lists=new String();
        if(resultSet.next()) {
            string_lists = resultSet.getString(4);
        }
        ArrayList<PurchaseList> ar_list=new ArrayList<PurchaseList>();
        if(string_lists==null){
            return ar_list;
        }
        else{
            String list_id="";
            for(int i=0;i<string_lists.length();i++){
                if(string_lists.charAt(i)==',' ){
                    ps =c.prepareStatement("SELECT *  FROM lists where id='"+list_id+"'");
                    resultSet=ps.executeQuery("SELECT *  FROM lists where id='"+list_id+"'");
                    if(resultSet.next()) {
                        ArrayList<Purchase> pr = new ArrayList<Purchase>();
                        ar_list.add(new PurchaseList(Integer.parseInt(list_id),resultSet.getString(2),resultSet.getString(3),pr));
                        list_id="";

                        continue;
                    }
                }
                list_id=list_id+String.valueOf(string_lists.charAt(i));
            }

        }

        return ar_list;
    }

    public static boolean deleteList(int id,User user) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        Statement stmt;
        stmt=c.createStatement();
        stmt.executeUpdate("DELETE FROM lists where id='"+Integer.toString(id)+"'");

        PreparedStatement ps=c.prepareStatement("SELECT *  FROM users where name='"+user.name+"'");
        ResultSet resultSet=ps.executeQuery("SELECT *  FROM users where name='"+user.name+"'");
        String string_lists=new String();
        if(resultSet.next()){
            string_lists=resultSet.getString(4);
        }

        string_lists=string_lists.replaceAll(Integer.toString(id)+",", "");


        Statement stmt1;
        stmt1=c.createStatement();
        String sql = "UPDATE users set lists='"+string_lists+"' where name='" +user.name+"'";
        stmt1.executeUpdate(sql);

        return true;
    }

    public static ArrayList<Purchase> getListPurchases(int id) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        PreparedStatement ps=c.prepareStatement("SELECT *  FROM lists where name='"+Integer.toString(id)+"'");
        ResultSet resultSet=ps.executeQuery("SELECT *  FROM lists where name='"+Integer.toString(id)+"'");

        String string_lists=new String();
        if(resultSet.next()) {
            string_lists = resultSet.getString(4);
        }

        ArrayList<Purchase> ar_list=new ArrayList<Purchase>();
        if(string_lists==null){
            return ar_list;
        }
        else{
            String list_id="";
            for(int i=0;i<string_lists.length();i++){
                if(string_lists.charAt(i)==',' ){
                    ps =c.prepareStatement("SELECT *  FROM purchase where id='"+list_id+"'");
                    resultSet=ps.executeQuery("SELECT *  FROM purchase where id='"+list_id+"'");
                    if(resultSet.next()) {
                        ar_list.add(new Purchase(Integer.parseInt(list_id),resultSet.getString(2),resultSet.getString(3),resultSet.getBoolean(5)));
                        list_id="";
                        continue;
                    }
                }
                list_id=list_id+String.valueOf(string_lists.charAt(i));
            }

        }

        return ar_list;
    }




    public static int addPurchase(Purchase purchase,int list_id) throws SQLException, ClassNotFoundException {
        Connection c = getConnection();
        Statement stmt;
        stmt=c.createStatement();
        String sql;
        sql = "INSERT INTO purchase(name,cout,status,host_id) " + "VALUES('" + purchase.name + "','"+ purchase.count + "','"+ "0" + "','"+ list_id + "')";
        stmt.executeUpdate(sql);

        PreparedStatement ps=c.prepareStatement("SELECT *  FROM lists where name='"+list_id+"'");
        ResultSet resultSet=ps.executeQuery("SELECT *  FROM lists where name='"+list_id+"'");
        int id=0;
        while(resultSet.next()){
            id=resultSet.getInt(1);
        }

        purchase.id=id;
        return id;
    }

    public static boolean updateListPurchase(int id,int purchaseList_id) throws SQLException, ClassNotFoundException {


        Connection c = getConnection();


        PreparedStatement ps=c.prepareStatement("SELECT *  FROM lists where name='"+Integer.toString(purchaseList_id)+"'");
        ResultSet resultSet=ps.executeQuery("SELECT *  FROM lists where name='"+Integer.toString(purchaseList_id)+"'");
        String string_lists=new String();
        if(resultSet.next()){
            string_lists=resultSet.getString(4);
        }
        else
            return false;

        if(string_lists==null){
            string_lists=new String();
            string_lists=string_lists+Integer.toString(id)+",";
        }
        else{
            string_lists=string_lists+Integer.toString(id)+",";
        }

        Statement stmt;
        stmt=c.createStatement();
        String sql = "UPDATE lists set purchase='"+string_lists+"' where id='" +Integer.toString(purchaseList_id)+"'";
        stmt.executeUpdate(sql);

        return true;
    }



}
