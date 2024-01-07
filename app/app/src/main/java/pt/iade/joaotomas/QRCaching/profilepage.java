package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.adapters.eventlist_adapter;
import pt.iade.joaotomas.QRCaching.adapters.qrcodelist_adapter;
import pt.iade.joaotomas.QRCaching.models.EventItem;
import pt.iade.joaotomas.QRCaching.models.QrcodeItem;


public class profilepage extends AppCompatActivity {
    private Button gobackbutton;
    private RecyclerView itemsListView;
    protected qrcodelist_adapter qrcodelistAdapter;
    private static final int EDITOR_ACTIVITY_RETURN_ID = 1;

    private ArrayList<QrcodeItem> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
        gobackbutton = findViewById(R.id.goback_buttonprofile);

        Intent intent = getIntent();
        if (intent != null) {
            itemList = (ArrayList<QrcodeItem>) intent.getSerializableExtra("itemList");
            if (itemList == null) {
                itemList = new ArrayList<>();
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(profilepage.this, R.style.AlertDialogCustom);
            builder.setTitle("Failed to load Lists");
            builder.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
        setupComponents();
    }

    private void setupComponents() {
        QrcodeItem.List(new QrcodeItem.ListResponse() {
            @Override
            public void response(ArrayList<QrcodeItem> items) {
                itemList = items;

                qrcodelistAdapter = new qrcodelist_adapter(profilepage.this, itemList);
                qrcodelistAdapter.setOnClickListener(new qrcodelist_adapter.ItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(profilepage.this, qrcode.class);
                        intent.putExtra("position", position);
                        intent.putExtra("item", itemList.get(position));

                        startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
                    }
                });

            }
        });

        itemsListView = (RecyclerView) findViewById(R.id.qrcode_list);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));
        itemsListView.setAdapter(qrcodelistAdapter);

    }

}