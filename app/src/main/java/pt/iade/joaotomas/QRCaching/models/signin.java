package pt.iade.joaotomas.QRCaching.models;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.iade.joaotomas.QRCaching.R;

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
         //       Intent intent=new Intent(signin.this,mainpage.class);
         //       startActivity(intent);
                AlertDialog.Builder builder = new AlertDialog.Builder(signin.this);
                builder.setTitle("Work In Progress");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
            }
        });
    }
}