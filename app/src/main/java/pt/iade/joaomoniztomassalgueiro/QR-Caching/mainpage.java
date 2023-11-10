package pt.iade.joaomoniz.copypasteplayground;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;

public class mainpage extends AppCompatActivity {

private ImageButton profilepage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

    profilepage = findViewById(R.id.profilepicselect_imageButton);
        profilepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainpage.this,profilepage.class);
                startActivity(intent);
            }
        });
    }
}