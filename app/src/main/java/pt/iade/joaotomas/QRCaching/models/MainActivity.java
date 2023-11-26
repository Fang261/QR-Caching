package pt.iade.joaotomas.QRCaching.models;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import pt.iade.joaotomas.QRCaching.R;


public class MainActivity extends AppCompatActivity {
    private Button loginbutton;
    private Button guestloginbutton;
    private Button signinbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginbutton = findViewById(R.id.login_button);
        guestloginbutton = findViewById(R.id.signguest_button);
        signinbutton = findViewById(R.id.signup_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
       //         Intent intent=new Intent(MainActivity.this,mainpage.class);
       //         startActivity(intent);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Work In Progress");
                builder.setPositiveButton("WIP", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
            }
        });
        signinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,signin.class);
                startActivity(intent);
            }
        });
        guestloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,mainpage.class);
                startActivity(intent);
            }
        });
    }
}