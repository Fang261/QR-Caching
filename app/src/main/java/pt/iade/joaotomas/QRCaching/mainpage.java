package pt.iade.joaotomas.QRCaching;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;


public class mainpage extends AppCompatActivity {

private ImageButton profilepage;

private ImageButton mappage;

private ImageButton eventpage;
private ImageButton btn_scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        btn_scan =findViewById(R.id.btn_scan);
        profilepage = findViewById(R.id.profilepic_imageButton);
        mappage = findViewById(R.id.map_imageButton);
        eventpage = findViewById(R.id.events_imageButton);
        profilepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainpage.this,profilepage.class);
                startActivity(intent);
            }
        });
        btn_scan.setOnClickListener(v->
    {
        scanCode();
    });

        mappage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainpage.this,map.class);
                startActivity(intent);
            }
        });
        eventpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainpage.this,eventlist.class);
                startActivity(intent);
            }
        });
}
    private  void scanCode()
    {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume Up To Turn On Flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result ->
    {
        if(result.getContents() !=null){
            AlertDialog.Builder builder = new AlertDialog.Builder(mainpage.this);
            builder.setTitle("Result");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });
}