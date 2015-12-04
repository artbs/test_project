import java.util.Date;

/**
 * Created by Zhuk on 17.12.2015.
 */
public class Purchase {//incapsukation!!!!
    public int id;//
    public String name;
    public String count;
    public boolean status;

    public  Purchase(int _id,String _name,String _count,boolean _status)
    {
        id=_id;
        name=_name;
        count=_count;
        status=_status;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String  getName() {return name;}
    public void setCount(String count) {
        this.count = count;
    }
    public String  getCount() {return count;}

    public void setStatus(boolean id) {
        this.status = id;
    }
    public boolean getStatus() {return status;}

}
