package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableRow;


public class profilepage extends AppCompatActivity {

private Button gobackbutton;

private TableRow LocationTable;
private TableRow EventTable;

private Spinner list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);
    gobackbutton = findViewById(R.id.goback_button);
    list = findViewById(R.id.record_spinner);
    LocationTable = findViewById(R.id.locations_table);
    EventTable = findViewById(R.id.events_table);

    list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            LocationTable.setVisibility(View.GONE);
            EventTable.setVisibility(View.GONE);
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