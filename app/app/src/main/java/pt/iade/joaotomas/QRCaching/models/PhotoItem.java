package pt.iade.joaotomas.QRCaching.models;

import android.media.Image;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.utilities.WebRequest;

public class PhotoItem implements Serializable {
    private int id;
    private String photoPath;


    public PhotoItem() {
        this(0,"");
    }


    public PhotoItem(int id,String photoPath) {
        this.id = id;
        this.photoPath = photoPath;
    }

    public static void List(PhotoItem.ListResponse response) {
        ArrayList<PhotoItem> items = new ArrayList<PhotoItem>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/photo"));
                        String resp = req.performGetRequest();

                        JsonObject json = new Gson().fromJson(resp, JsonObject.class);
                        JsonArray arr = json.getAsJsonArray("items");
                        ArrayList<PhotoItem> items = new ArrayList<PhotoItem>();
                        for (JsonElement elem : arr) {
                            items.add(new Gson().fromJson(elem, PhotoItem.class));
                        }

                        response.response(items);
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("PhotoItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void GetById(int id, EventItem.GetByIdResponse response) {
        // Fetch the item from the web server using its id and populate the object.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/photo/" + id));
                        String resp = req.performGetRequest();

                        response.response(new Gson().fromJson(resp, EventItem.class));
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("PhotoItem", e.toString());
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
                                    WebRequest.LOCALHOST + "/photo/new"));
                            String response = req.performPostRequest(PhotoItem.this);

                            EventItem respItem = new Gson().fromJson(response, EventItem.class);
                            id = respItem.getId();
                        } else {
                            WebRequest req = new WebRequest(new URL(
                                    WebRequest.LOCALHOST + "/photo/" + id));
                            req.performPostRequest(PhotoItem.this);
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("PhotoItem", e.toString());
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
                                    WebRequest.LOCALHOST + "/photo/" + id));
                            req.performDeleteRequest();
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("PhotoItem", e.toString());
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

    public String getphotoPath() { return photoPath; }

    public void setphotoPath(String photoUrl) { this.photoPath = photoPath; }

    public interface ListResponse {
        public void response(ArrayList<PhotoItem> items);
    }

    public interface GetByIdResponse {
        public void response(PhotoItem item);
    }
}
