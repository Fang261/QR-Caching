package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pt.iade.joaotomas.QRCaching.models.eventitem;

public class event_page extends AppCompatActivity {
    //protected EditText street;
    protected eventitem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);

        item = new eventitem();

        setupComponents();
    }

    private void setupComponents() {
        //street = (EditText);
    }
}