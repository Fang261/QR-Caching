package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import pt.iade.joaotomas.QRCaching.R;
import pt.iade.joaotomas.QRCaching.models.eventrow;

public class event_page extends AppCompatActivity {
    //protected EditText street;
    protected eventrow item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);

        item = new eventrow();

        setupComponents();
    }

    private void setupComponents() {
        //street = (EditText);
    }
}