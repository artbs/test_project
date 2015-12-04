import java.util.ArrayList;

/**
 * Created by Zhuk on 17.12.2015.
 */
public class User {
    public int id;
    public String name;
    public String password;
    ArrayList<PurchaseList> lists;
    ArrayList<User>    friends;

    boolean online=false;
    String  connection_host;

    public static ArrayList<User> Users=new ArrayList<User>();

    public  User(int _id,String _name,String _password,ArrayList<PurchaseList> _lists,ArrayList<User>  _friends,String _connection_host)
    {
        id=_id;
        name=_name;
        password=_password;
        lists=_lists;
        friends=_friends;
        connection_host=_connection_host;
    }

    public void setOnline(boolean _online)
    {
        online=_online;
    }



}
