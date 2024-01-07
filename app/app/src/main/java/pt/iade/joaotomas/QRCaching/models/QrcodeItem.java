package pt.iade.joaotomas.QRCaching.models;

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

public class QrcodeItem implements Serializable {
    private int id;
    private String streetName;
    private float latitude;
    private float longitude;
    private float altitude;
    private ArrayList<PhotoItem> photos;
    private String qrcode;

    public QrcodeItem() {this(0, "Name", "streetName", 0,0 , 0, null,"qrcode");}

    public QrcodeItem(int id, String name, String streetName, float latitude, float longitude, float altitude, ArrayList<PhotoItem> photos,String qrcode) {
        this.id = id;
        this.streetName = streetName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.photos = photos;
        this.qrcode = qrcode;
    }

    public static void List(QrcodeItem.ListResponse response) {
        ArrayList<QrcodeItem> items = new ArrayList<QrcodeItem>();

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
                        ArrayList<QrcodeItem> items = new ArrayList<QrcodeItem>();
                        for (JsonElement elem : arr) {
                            items.add(new Gson().fromJson(elem, QrcodeItem.class));
                        }

                        response.response(items);
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("QrcodeItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public static void GetById(int id, QrcodeItem.GetByIdResponse response) {
        // Fetch the item from the web server using its id and populate the object.
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        WebRequest req = new WebRequest(new URL(
                                WebRequest.LOCALHOST + "/qrcode/" + id));
                        String resp = req.performGetRequest();

                        response.response(new Gson().fromJson(resp, QrcodeItem.class));
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("QrcodeItem", e.toString());
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
                                    WebRequest.LOCALHOST + "/qrcode/new"));
                            String response = req.performPostRequest(QrcodeItem.this);

                            QrcodeItem respItem = new Gson().fromJson(response, QrcodeItem.class);
                            id = respItem.getId();
                        } else {
                            WebRequest req = new WebRequest(new URL(
                                    WebRequest.LOCALHOST + "/qrcode/" + id));
                            req.performPostRequest(QrcodeItem.this);
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("QrcodeItem", e.toString());
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
                                    WebRequest.LOCALHOST + "/qrcode/" + id));
                            req.performDeleteRequest();
                        }
                    } catch (Exception e) {
                        Toast.makeText(null, "Web request failed: " + e.toString(),
                                Toast.LENGTH_LONG).show();
                        Log.e("QrcodeItem", e.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public int getId() { return id; }

    public String getStreetName() { return streetName; }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public float getLatitude() { return latitude; }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() { return longitude; }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getAltitude() { return altitude; }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public ArrayList<PhotoItem> getPhotos() { return photos; }

    public void setPhotos(ArrayList<PhotoItem> photos) {
        this.photos = photos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public interface ListResponse {
        public void response(ArrayList<QrcodeItem> items);
    }

    public interface GetByIdResponse {
        public void response(QrcodeItem item);
    }
}