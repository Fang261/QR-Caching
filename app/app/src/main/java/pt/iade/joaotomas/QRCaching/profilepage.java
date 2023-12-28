package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.adapters.qrcodelist_adapter;
import pt.iade.joaotomas.QRCaching.models.QrcodeItem;


public class profilepage extends AppCompatActivity {
    private Button gobackbutton;
    private RecyclerView itemsListView;
    protected qrcodelist_adapter qrcodelistAdapter;

    protected ArrayList<QrcodeItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        gobackbutton = findViewById(R.id.goback_buttonprofile);

    }

    private void setupComponents() {
        qrcodelistAdapter = new qrcodelist_adapter(this, itemList);

        // set up the qrcode list recycler view
        itemsListView = (RecyclerView) findViewById(R.id.qrcode_list);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));
        itemsListView.setAdapter(qrcodelistAdapter);

    }

}