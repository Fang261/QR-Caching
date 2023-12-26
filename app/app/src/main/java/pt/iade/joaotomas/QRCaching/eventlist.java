package pt.iade.joaotomas.QRCaching;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.adapters.eventlist_adapter;


import pt.iade.joaotomas.QRCaching.models.eventItem;


public class eventlist extends AppCompatActivity {
    private RecyclerView itemsListView;
    protected eventlist_adapter eventlistAdapter;

    protected ArrayList<eventItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);
    }

    private void setupComponents() {
        eventlistAdapter = new eventlist_adapter(this, itemList);

        // set up the event list recycler view
        itemsListView = (RecyclerView) findViewById(R.id.event_list);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));
        itemsListView.setAdapter(eventlistAdapter);

    }

}