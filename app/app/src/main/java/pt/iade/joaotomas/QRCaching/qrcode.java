package pt.iade.joaotomas.QRCaching;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.models.QrcodeItem;

public class qrcode extends AppCompatActivity {

    private ImageButton picture;
    private ImageButton vault;
    private ArrayList<QrcodeItem> itemList;
    private TextView streetname;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        itemList = new ArrayList<>();
        String QRCodeValue = getIntent().getStringExtra("QRCodeValue");
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        picture = findViewById(R.id.photo_imageButton);
        vault = findViewById(R.id.photo_imageButton);
        streetname = findViewById(R.id.streename_textView);

        for (QrcodeItem qrcode : itemList) {
            if (qrcode.getQrcode().equals(QRCodeValue)) {
                streetname.setText(qrcode.getStreetName());
                break;
            }
        }

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent(QRCodeValue);
            }
        });

        vault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(qrcode.this,vault.class);
                intent.putExtra("QRCodeValue", QRCodeValue);
                intent.putExtra("itemList", itemList);
                startActivity(intent);
            }
        });
    }

    private void dispatchTakePictureIntent(String QRCodeValue) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            currentPhotoPath = data.getStringExtra("PhotoPath");

            Log.d("qrcode", "Photo Path: " + currentPhotoPath);
        }
    }
}
