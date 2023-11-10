package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.iade.joaomoniz.copypasteplayground.R;

public class signin extends AppCompatActivity {

private Button loginbutton;
private Button confirmbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        loginbutton = (Button) (findViewById(R.id.login_button2));
        confirmbutton = (Button) (findViewById(R.id.confirm_button));
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signin.this,MainActivity.class);
                startActivity(intent);
            }
        });
        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signin.this,mainpage.class);
                startActivity(intent);
            }
        });
    }
}