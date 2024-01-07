package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.models.QrcodeItem;

public class qrcode extends AppCompatActivity {

    private ImageButton picture;
    private ImageButton vault;
    private ArrayList<QrcodeItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String qrCodeValue = getIntent().getStringExtra("QRCodeValue");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        picture = findViewById(R.id.photo_imageButton);
        vault = findViewById(R.id.photo_imageButton);
        Intent intent = getIntent();
        if (intent != null) {
            itemList = (ArrayList<QrcodeItem>) intent.getSerializableExtra("itemList");
            if (itemList == null) {
                itemList = new ArrayList<>();
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(qrcode.this, R.style.AlertDialogCustom);
            builder.setTitle("Failed to load Lists");
            builder.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(qrcode.this,takephoto.class);
                startActivity(intent);

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