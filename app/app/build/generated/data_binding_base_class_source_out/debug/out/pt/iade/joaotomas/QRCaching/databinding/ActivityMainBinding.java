// Generated by view binder compiler. Do not edit!
package pt.iade.joaotomas.QRCaching.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TableLayout autorTable;

  @NonNull
  public final TableRow autorTable0550;

  @NonNull
  public final TextView autorTable0550Text;

  @NonNull
  public final TableRow autorTable0589;

  @NonNull
  public final TextView autorTable0589Text;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final ImageView logoImage;

  @NonNull
  public final TextView logoText;

  @NonNull
  public final EditText passwordEditText;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final Button signguestButton;

  @NonNull
  public final Button signupButton;

  @NonNull
  public final EditText usernameEditText;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull TableLayout autorTable,
      @NonNull TableRow autorTable0550, @NonNull TextView autorTable0550Text,
      @NonNull TableRow autorTable0589, @NonNull TextView autorTable0589Text,
      @NonNull Button loginButton, @NonNull ImageView logoImage, @NonNull TextView logoText,
      @NonNull EditText passwordEditText, @NonNull RelativeLayout relativeLayout,
      @NonNull Button signguestButton, @NonNull Button signupButton,
      @NonNull EditText usernameEditText) {
    this.rootView = rootView;
    this.autorTable = autorTable;
    this.autorTable0550 = autorTable0550;
    this.autorTable0550Text = autorTable0550Text;
    this.autorTable0589 = autorTable0589;
    this.autorTable0589Text = autorTable0589Text;
    this.loginButton = loginButton;
    this.logoImage = logoImage;
    this.logoText = logoText;
    this.passwordEditText = passwordEditText;
    this.relativeLayout = relativeLayout;
    this.signguestButton = signguestButton;
    this.signupButton = signupButton;
    this.usernameEditText = usernameEditText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.autor_table;
      TableLayout autorTable = ViewBindings.findChildViewById(rootView, id);
      if (autorTable == null) {
        break missingId;
      }

      id = R.id.autor_table_0550;
      TableRow autorTable0550 = ViewBindings.findChildViewById(rootView, id);
      if (autorTable0550 == null) {
        break missingId;
      }

      id = R.id.autor_table_0550_text;
      TextView autorTable0550Text = ViewBindings.findChildViewById(rootView, id);
      if (autorTable0550Text == null) {
        break missingId;
      }

      id = R.id.autor_table_0589;
      TableRow autorTable0589 = ViewBindings.findChildViewById(rootView, id);
      if (autorTable0589 == null) {
        break missingId;
      }

      id = R.id.autor_table_0589_text;
      TextView autorTable0589Text = ViewBindings.findChildViewById(rootView, id);
      if (autorTable0589Text == null) {
        break missingId;
      }

      id = R.id.login_button;
      Button loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.logo_image;
      ImageView logoImage = ViewBindings.findChildViewById(rootView, id);
      if (logoImage == null) {
        break missingId;
      }

      id = R.id.logo_text;
      TextView logoText = ViewBindings.findChildViewById(rootView, id);
      if (logoText == null) {
        break missingId;
      }

      id = R.id.passwordEditText;
      EditText passwordEditText = ViewBindings.findChildViewById(rootView, id);
      if (passwordEditText == null) {
        break missingId;
      }

      id = R.id.relativeLayout;
      RelativeLayout relativeLayout = ViewBindings.findChildViewById(rootView, id);
      if (relativeLayout == null) {
        break missingId;
      }

      id = R.id.signguest_button;
      Button signguestButton = ViewBindings.findChildViewById(rootView, id);
      if (signguestButton == null) {
        break missingId;
      }

      id = R.id.signup_button;
      Button signupButton = ViewBindings.findChildViewById(rootView, id);
      if (signupButton == null) {
        break missingId;
      }

      id = R.id.usernameEditText;
      EditText usernameEditText = ViewBindings.findChildViewById(rootView, id);
      if (usernameEditText == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, autorTable, autorTable0550,
          autorTable0550Text, autorTable0589, autorTable0589Text, loginButton, logoImage, logoText,
          passwordEditText, relativeLayout, signguestButton, signupButton, usernameEditText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
