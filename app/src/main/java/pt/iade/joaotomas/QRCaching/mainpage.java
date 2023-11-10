package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;

import pt.iade.joaomoniz.copypasteplayground.R;

public class mainpage extends AppCompatActivity {

private ImageButton profilepage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

    profilepage = findViewById(R.id.profilepic_imageButton);
        profilepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainpage.this,profilepage.class);
                startActivity(intent);
            }
        });
    }
}