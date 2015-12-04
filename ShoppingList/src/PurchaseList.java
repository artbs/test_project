import java.util.ArrayList;

/**
 * Created by Zhuk on 17.12.2015.
 */
public class PurchaseList {
    public int id;
    public String name;
    public String comments;
    public String status="0%";
    ArrayList<Purchase> purchases;

    public PurchaseList(int _id,String _name,String _comments,ArrayList<Purchase> _purchases)
    {
        id=_id;
        name=_name;
        comments=_comments;
        purchases=_purchases;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String  getName() {return name;}
    public void setComments(String name) {
        this.comments = name;
    }
    public String  getComments() {return comments;}

    public void setId(int id) {
        this.id = id;
    }
    public int  getId() {return id;}

    public void setStatus(String name) {
        this.status = name;
    }
    public String  getStatus() {return status;}
}
