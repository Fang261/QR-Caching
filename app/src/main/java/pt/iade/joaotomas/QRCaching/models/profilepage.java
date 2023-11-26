package pt.iade.joaotomas.QRCaching.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableRow;

import pt.iade.joaotomas.QRCaching.R;


public class profilepage extends AppCompatActivity {

private Button gobackbutton;

private TableRow LocationTable;
private TableRow EventTable;
private Spinner list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
    gobackbutton = findViewById(R.id.goback_buttonprofile);
    list = findViewById(R.id.record_spinner);
    LocationTable = findViewById(R.id.locations_table);
    EventTable = findViewById(R.id.events_table);

    list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if (i == 0) {
                LocationTable.setVisibility(View.GONE);
                EventTable.setVisibility(View.VISIBLE);
            }
            else {
                LocationTable.setVisibility(View.VISIBLE);
                EventTable.setVisibility(View.GONE);
            };
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
        gobackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(profilepage.this,mainpage.class);
                startActivity(intent);
            }
        });
    }
}