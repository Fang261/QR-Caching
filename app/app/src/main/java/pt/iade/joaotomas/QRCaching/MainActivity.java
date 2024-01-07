package pt.iade.joaotomas.QRCaching;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.models.UserItem;


public class MainActivity extends AppCompatActivity {
    private Button loginbutton;
    private Button guestloginbutton;
    private Button signinbutton;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private static final int SIGN_IN_REQUEST_CODE = 1;

    private ArrayList<UserItem> UserList;

    private UserItem findUser(String username, String password) {
        for (UserItem user : UserList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserList = new ArrayList<>();

        loginbutton = findViewById(R.id.login_button);
        guestloginbutton = findViewById(R.id.signguest_button);
        signinbutton = findViewById(R.id.signup_button);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                UserItem currentUser = findUser(enteredUsername, enteredPassword);

                if (currentUser != null) {
                    Intent intent = new Intent(MainActivity.this, mainpage.class);

                    intent.putExtra("userId", currentUser.getId());
                    intent.putExtra("username", currentUser.getUsername());

                    startActivityForResult(intent, SIGN_IN_REQUEST_CODE);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Login Failed");
                    builder.setMessage("Invalid username or password.");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.show();
                }
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
                intent.putExtra("userId", -1);
                intent.putExtra("username", "Guest");


            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                int signedInUserId = data.getIntExtra("ID", 0);
                String signedInUsername = data.getStringExtra("username");
                String signedInPassword = data.getStringExtra("password");

                UserItem newUser = new UserItem(signedInUserId,signedInUsername,signedInPassword,null,null);
                UserList.add(newUser);
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Error");
                builder.setMessage("Something went wrong!");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        }
    }

    private UserItem findUserById(int userId) {
        for (UserItem user : UserList) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

}
