package pt.iade.joaotomas.QRCaching;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.models.QrcodeItem;
import pt.iade.joaotomas.QRCaching.models.UserItem;

public class signin extends AppCompatActivity {

    private Button loginbutton;
    private EditText usernameEditText;
    private EditText idEditText;
    private EditText passwordEditText;
    private Button confirmbutton;

    private ArrayList<UserItem> UserList;

    private void handleSignInResult(int newCreatedID, String signedInUsername, String signedInPassword) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("username", signedInUsername);
        resultIntent.putExtra("password", signedInPassword);
        resultIntent.putExtra("ID", newCreatedID);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        usernameEditText = findViewById(R.id.register_username_edit);
        idEditText = findViewById(R.id.register_id_edit);
        passwordEditText = findViewById(R.id.register_pw_edit);
        loginbutton = findViewById(R.id.login_button2);
        confirmbutton = findViewById(R.id.confirm_button);

        UserList = new ArrayList<>();
        Intent intent = getIntent();
        if (intent != null) {
            UserList = (ArrayList<UserItem>) intent.getSerializableExtra("itemList");
            if (UserList == null) {
                UserList = new ArrayList<>();
            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(signin.this, R.style.AlertDialogCustom);
            builder.setTitle("Failed to load Lists");
            builder.setPositiveButton("Ok", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signin.this, MainActivity.class);
                startActivity(intent);
            }
        });

        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                if (isValidCredentials(enteredUsername, enteredPassword)) {
                    int newId = UserItem.getLastAssignedId() + 1;
                    UserItem newUser = new UserItem(newId, enteredUsername, enteredPassword, null, null);
                    UserList.add(newUser);
                    UserItem.setLastAssignedId(newId);
                    Log.d("signin", "New user created - ID: " + newId + ", Username: " + newUser.getUsername() + ", Password: " + newUser.getPassword());
                    handleSignInResult(newId, newUser.getUsername(), newUser.getPassword());
                }
            }

            private boolean isValidCredentials(String username, String password) {
                if (username.length() < 3) {
                    showValidationDialog("Username must be at least 3 characters long.");
                    return false;
                }

                if (password.length() < 8) {
                    showValidationDialog("Password must be at least 8 characters long.");
                    return false;
                }

                return true;
            }

            private void showValidationDialog(String message) {
                AlertDialog.Builder builder = new AlertDialog.Builder(signin.this, R.style.AlertDialogCustom);
                builder.setTitle("Validation Error");
                builder.setMessage(message);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }

            private void handleSignInResult(int newCreatedID, String signedInUsername, String signedInPassword) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("username", signedInUsername);
                resultIntent.putExtra("password", signedInPassword);
                resultIntent.putExtra("ID", newCreatedID);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

    }
}
