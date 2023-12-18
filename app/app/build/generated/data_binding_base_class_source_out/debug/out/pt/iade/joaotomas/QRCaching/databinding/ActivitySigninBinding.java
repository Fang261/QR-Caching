// Generated by view binder compiler. Do not edit!
package pt.iade.joaotomas.QRCaching.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pt.iade.joaotomas.QRCaching.R;

public final class ActivitySigninBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button confirmButton;

  @NonNull
  public final Button loginButton2;

  @NonNull
  public final ImageView logoImage2;

  @NonNull
  public final TextView logoText2;

  @NonNull
  public final TableLayout register;

  @NonNull
  public final TableRow registerEmail;

  @NonNull
  public final EditText registerEmailEdit;

  @NonNull
  public final TextView registerEmailText;

  @NonNull
  public final TableRow registerId;

  @NonNull
  public final EditText registerIdEdit;

  @NonNull
  public final TextView registerIdText;

  @NonNull
  public final TableRow registerPassword;

  @NonNull
  public final EditText registerPwEdit;

  @NonNull
  public final TextView registerPwText;

  @NonNull
  public final TableRow registerUsername;

  @NonNull
  public final EditText registerUsernameEdit;

  @NonNull
  public final TextView registerUsernameText;

  private ActivitySigninBinding(@NonNull ConstraintLayout rootView, @NonNull Button confirmButton,
      @NonNull Button loginButton2, @NonNull ImageView logoImage2, @NonNull TextView logoText2,
      @NonNull TableLayout register, @NonNull TableRow registerEmail,
      @NonNull EditText registerEmailEdit, @NonNull TextView registerEmailText,
      @NonNull TableRow registerId, @NonNull EditText registerIdEdit,
      @NonNull TextView registerIdText, @NonNull TableRow registerPassword,
      @NonNull EditText registerPwEdit, @NonNull TextView registerPwText,
      @NonNull TableRow registerUsername, @NonNull EditText registerUsernameEdit,
      @NonNull TextView registerUsernameText) {
    this.rootView = rootView;
    this.confirmButton = confirmButton;
    this.loginButton2 = loginButton2;
    this.logoImage2 = logoImage2;
    this.logoText2 = logoText2;
    this.register = register;
    this.registerEmail = registerEmail;
    this.registerEmailEdit = registerEmailEdit;
    this.registerEmailText = registerEmailText;
    this.registerId = registerId;
    this.registerIdEdit = registerIdEdit;
    this.registerIdText = registerIdText;
    this.registerPassword = registerPassword;
    this.registerPwEdit = registerPwEdit;
    this.registerPwText = registerPwText;
    this.registerUsername = registerUsername;
    this.registerUsernameEdit = registerUsernameEdit;
    this.registerUsernameText = registerUsernameText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySigninBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySigninBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySigninBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.confirm_button;
      Button confirmButton = ViewBindings.findChildViewById(rootView, id);
      if (confirmButton == null) {
        break missingId;
      }

      id = R.id.login_button2;
      Button loginButton2 = ViewBindings.findChildViewById(rootView, id);
      if (loginButton2 == null) {
        break missingId;
      }

      id = R.id.logo_image2;
      ImageView logoImage2 = ViewBindings.findChildViewById(rootView, id);
      if (logoImage2 == null) {
        break missingId;
      }

      id = R.id.logo_text2;
      TextView logoText2 = ViewBindings.findChildViewById(rootView, id);
      if (logoText2 == null) {
        break missingId;
      }

      id = R.id.register;
      TableLayout register = ViewBindings.findChildViewById(rootView, id);
      if (register == null) {
        break missingId;
      }

      id = R.id.register_email;
      TableRow registerEmail = ViewBindings.findChildViewById(rootView, id);
      if (registerEmail == null) {
        break missingId;
      }

      id = R.id.register_email_edit;
      EditText registerEmailEdit = ViewBindings.findChildViewById(rootView, id);
      if (registerEmailEdit == null) {
        break missingId;
      }

      id = R.id.register_email_text;
      TextView registerEmailText = ViewBindings.findChildViewById(rootView, id);
      if (registerEmailText == null) {
        break missingId;
      }

      id = R.id.register_id;
      TableRow registerId = ViewBindings.findChildViewById(rootView, id);
      if (registerId == null) {
        break missingId;
      }

      id = R.id.register_id_edit;
      EditText registerIdEdit = ViewBindings.findChildViewById(rootView, id);
      if (registerIdEdit == null) {
        break missingId;
      }

      id = R.id.register_id_text;
      TextView registerIdText = ViewBindings.findChildViewById(rootView, id);
      if (registerIdText == null) {
        break missingId;
      }

      id = R.id.register_password;
      TableRow registerPassword = ViewBindings.findChildViewById(rootView, id);
      if (registerPassword == null) {
        break missingId;
      }

      id = R.id.register_pw_edit;
      EditText registerPwEdit = ViewBindings.findChildViewById(rootView, id);
      if (registerPwEdit == null) {
        break missingId;
      }

      id = R.id.register_pw_text;
      TextView registerPwText = ViewBindings.findChildViewById(rootView, id);
      if (registerPwText == null) {
        break missingId;
      }

      id = R.id.register_username;
      TableRow registerUsername = ViewBindings.findChildViewById(rootView, id);
      if (registerUsername == null) {
        break missingId;
      }

      id = R.id.register_username_edit;
      EditText registerUsernameEdit = ViewBindings.findChildViewById(rootView, id);
      if (registerUsernameEdit == null) {
        break missingId;
      }

      id = R.id.register_username_text;
      TextView registerUsernameText = ViewBindings.findChildViewById(rootView, id);
      if (registerUsernameText == null) {
        break missingId;
      }

      return new ActivitySigninBinding((ConstraintLayout) rootView, confirmButton, loginButton2,
          logoImage2, logoText2, register, registerEmail, registerEmailEdit, registerEmailText,
          registerId, registerIdEdit, registerIdText, registerPassword, registerPwEdit,
          registerPwText, registerUsername, registerUsernameEdit, registerUsernameText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}