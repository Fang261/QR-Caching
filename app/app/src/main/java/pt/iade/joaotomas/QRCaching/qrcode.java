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

import pt.iade.joaotomas.QRCaching.models.PhotoItem;
import pt.iade.joaotomas.QRCaching.models.QrcodeItem;
import pt.iade.joaotomas.QRCaching.adapters.photolist_adapter;

public class qrcode extends AppCompatActivity {

    private ImageButton picture;
    private ImageButton vault;
    private ArrayList<QrcodeItem> itemList;
    private TextView streetname;

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ArrayList<PhotoItem> photoList;
    private photolist_adapter photolist_adapter;

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

    private void handlePictureResult(String QRCodeValue, String photoPath) {
        if (photolist_adapter != null) {
            photolist_adapter.notifyDataSetChanged();
        }

        for (QrcodeItem qrcode : itemList) {
            if (qrcode.getQrcode().equals(QRCodeValue)) {
                int ID = qrcode.getLastAssignedId()+1;
                PhotoItem newPhoto = new PhotoItem(ID,photoPath);
                qrcode.addPhoto(newPhoto);
                photoList = qrcode.getPhotos();
                break;
            }
        }
        if (photolist_adapter != null) {
            photolist_adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String QRCodeValue = getIntent().getStringExtra("QRCodeValue");

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            String currentPhotoPath = data.getStringExtra("PhotoPath");
            handlePictureResult(QRCodeValue, currentPhotoPath);
            Log.d("qrcode", "Photo Path: " + currentPhotoPath);
        }
    }

}
