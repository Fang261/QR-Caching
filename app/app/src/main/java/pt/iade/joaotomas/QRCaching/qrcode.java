package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class qrcode extends AppCompatActivity {

    private ImageButton picture;
    private ImageButton write;
    private ImageButton vault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String qrCodeValue = getIntent().getStringExtra("QRCodeValue");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        picture = findViewById(R.id.photo_imageButton);
        write = findViewById(R.id.write_imageButton);
        vault = findViewById(R.id.photo_imageButton);

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //  Intent intent=new Intent(qrcode.this,x.class);
             //  startActivity(intent);
                AlertDialog.Builder builder = new AlertDialog.Builder(qrcode.this);
                builder.setTitle("Work In Progress");
                builder.setPositiveButton("WIP", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
            }
        });
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent intent=new Intent(qrcode.this,x.class);
              //  startActivity(intent);
                AlertDialog.Builder builder = new AlertDialog.Builder(qrcode.this);
                builder.setTitle("Work In Progress");
                builder.setPositiveButton("WIP", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
            }
        });
        vault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(qrcode.this,vault.class);
                startActivity(intent);
            }
        });

    }
}