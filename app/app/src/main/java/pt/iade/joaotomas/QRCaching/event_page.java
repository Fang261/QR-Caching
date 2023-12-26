package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pt.iade.joaotomas.QRCaching.models.EventItem;

public class event_page extends AppCompatActivity {
    //protected EditText street;
    protected EventItem item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);


        item = new EventItem();

        setupComponents();
    }

    private void setupComponents() {
        //street = (EditText);
    }
}