package pt.iade.joaotomas.QRCaching.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserItem {
    private int id;
    private String username;
    private String password;
    private ArrayList<Integer> QRIDCompleted;
    private ArrayList<Integer> Achievments;

    public UserItem() {this(0,"username","password",null,null);}

    public UserItem(int id,String username,String password, ArrayList<Integer> QRIDCompleted, ArrayList Acheivments) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.QRIDCompleted = QRIDCompleted;
        this.Achievments = Acheivments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Integer> getQRIDCompleted() {
        return QRIDCompleted;
    }

    public void setQRIDCompleted(ArrayList<Integer> QRIDCompleted) {
        this.QRIDCompleted = QRIDCompleted;
    }

    public ArrayList<Integer> getAchievments() {
        return Achievments;
    }

    public void setAchievments(ArrayList<Integer> achievments) {
        Achievments = achievments;
    }
}