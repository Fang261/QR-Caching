package pt.iade.joaotomas.QRCaching.models;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.utilities.WebRequest;

public class UserItem implements Serializable {
    private int id;
    private String username;
    private String password;
    private ArrayList<Integer> QRIDCompleted;
    private ArrayList<Integer> Achievments;
    private static int lastAssignedId = 0;

    public UserItem() {this(0,"username","password",null,null);}

    public UserItem(int id,String username,String password, ArrayList<Integer> QRIDCompleted, ArrayList Acheivments) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.QRIDCompleted = QRIDCompleted;
        this.Achievments = Acheivments;
    }

    public static void List(UserItem.ListResponse response) {
        ArrayList<UserItem> items = new ArrayList<UserItem>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/user"));
                        String resp = req.performGetRequest();

                        JsonObject json = new Gson().fromJson(resp, JsonObject.class);
                        JsonArray arr = json.getAsJsonArray("items");
                        ArrayList<UserItem> items = new ArrayList<UserItem>();
                        for (JsonElement elem : arr) {
                            items.add(new Gson().fromJson(elem, UserItem.class));
                        }

                        response.response(items);
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("UserItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void GetById(int id, UserItem.GetByIdResponse response) {
        // Fetch the item from the web server using its id and populate the object.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/user/" + id));
                        String resp = req.performGetRequest();

                        response.response(new Gson().fromJson(resp, UserItem.class));
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("UserItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void save() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        if (id == 0) {
                            WebRequest req = new WebRequest(new URL(
                                    WebRequest.LOCALHOST + "/user/new"));
                            String response = req.performPostRequest(UserItem.this);

                            UserItem respItem = new Gson().fromJson(response, UserItem.class);
                            id = respItem.getId();
                        } else {
                            WebRequest req = new WebRequest(new URL(
                                    WebRequest.LOCALHOST + "/user/" + id));
                            req.performPostRequest(UserItem.this);
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("UserItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void delete() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        if (id != 0) {
                            WebRequest req = new WebRequest(new URL(
                                    WebRequest.LOCALHOST + "/user/" + id));
                            req.performDeleteRequest();
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("UserItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getLastAssignedId() {
        return lastAssignedId;
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

    public static void setLastAssignedId(int lastAssignedId) {
        UserItem.lastAssignedId = lastAssignedId;
    }

    public interface ListResponse {
        public void response(ArrayList<UserItem> items);
    }

    public interface GetByIdResponse {
        public void response(UserItem item);
    }
}
