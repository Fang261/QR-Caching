package pt.iade.joaotomas.QRCaching.models;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import pt.iade.joaotomas.QRCaching.utilities.WebRequest;

public class EventItem implements Serializable {
    private int id;
    private String eventname;
    private float latitude;
    private float longitude;
    private String idate;
    private String fdate;



    public EventItem() {
        this(0, "", 0, 0, "", "");
    }


    //Constructor
    public EventItem(int id, String eventname, float latitude, float longitude, String idate, String fdate) {
        this.id = id;
        this.eventname = eventname;
        this.latitude = latitude;
        this.longitude = longitude;
        this.idate = idate;
        this.fdate = fdate;
    }

    public static void List(ListResponse response) {
        ArrayList<EventItem> items = new ArrayList<EventItem>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/list"));
                        String resp = req.performGetRequest();

                        JsonObject json = new Gson().fromJson(resp, JsonObject.class);
                        JsonArray arr = json.getAsJsonArray("items");
                        ArrayList<EventItem> items = new ArrayList<EventItem>();
                        for (JsonElement elem : arr) {
                            items.add(new Gson().fromJson(elem, EventItem.class));
                        }

                        response.response(items);
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("EventItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void GetById(int id, GetByIdResponse response) {
        // Fetch the item from the web server using its id and populate the object.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/event/" + id));
                        String resp = req.performGetRequest();

                        response.response(new Gson().fromJson(resp, EventItem.class));
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("EventItem", e.toString());
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
                                    WebRequest.LOCALHOST + "/event/new"));
                            String response = req.performPostRequest(EventItem.this);

                            EventItem respItem = new Gson().fromJson(response, EventItem.class);
                            id = respItem.getId();
                        } else {
                            WebRequest req = new WebRequest(new URL(
                                    WebRequest.LOCALHOST + "/event/" + id));
                            req.performPostRequest(EventItem.this);
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("EventItem", e.toString());
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
                                    WebRequest.LOCALHOST + "/event/" + id));
                            req.performDeleteRequest();
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("EventItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getEventname() {
        return eventname;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getIdate() {
        return idate;
    }

    public String getFdate() {
        return fdate;
    }

    public interface ListResponse {
        public void response(ArrayList<EventItem> items);
    }

    public interface GetByIdResponse {
        public void response(EventItem item);
    }
}
