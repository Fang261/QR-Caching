package pt.iade.joaotomas.QRCaching;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.adapters.eventlist_adapter;

import pt.iade.joaotomas.QRCaching.models.EventItem;

public class eventlist extends AppCompatActivity {
    private RecyclerView itemsListView;
    protected eventlist_adapter eventlistAdapter;
    private static final int EDITOR_ACTIVITY_RETURN_ID = 1;

    protected ArrayList<EventItem> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventlist);
    }


    private void setupComponents() {
        EventItem.List(new EventItem.ListResponse() {
            @Override
            public void response(ArrayList<EventItem> items) {
                itemList = items;

                eventlistAdapter = new eventlist_adapter(eventlist.this, itemList);
                eventlistAdapter.setOnClickListener(new eventlist_adapter.ItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(eventlist.this, event_page.class);
                        intent.putExtra("position", position);
                        intent.putExtra("item", itemList.get(position));

                        startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
                    }
                });

            }
        });
        // set up the event list recycler view
        itemsListView = (RecyclerView) findViewById(R.id.event_list);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));
        itemsListView.setAdapter(eventlistAdapter);

    }

}