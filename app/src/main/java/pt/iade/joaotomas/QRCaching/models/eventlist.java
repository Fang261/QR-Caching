package pt.iade.joaotomas.QRCaching.models;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import pt.iade.joaotomas.QRCaching.R;


public class eventlist extends AppCompatActivity {

    private RecyclerView itemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);
    }

    private void setupComponents() {
        // set up the event list recycler view
        itemsListView = (RecyclerView) findViewById(R.id.event_list);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));

    }

}