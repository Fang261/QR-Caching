// Generated by view binder compiler. Do not edit!
package pt.iade.joaotomas.QRCaching.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
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

public final class ActivityVaultBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ProgressBar experiencebarProgressBar4;

  @NonNull
  public final Button gobackButtonvault;

  @NonNull
  public final ConstraintLayout header;

  @NonNull
  public final ConstraintLayout im;

  @NonNull
  public final TextView levelText;

  @NonNull
  public final ImageButton profilepicImageButton;

  private ActivityVaultBinding(@NonNull ConstraintLayout rootView,
      @NonNull ProgressBar experiencebarProgressBar4, @NonNull Button gobackButtonvault,
      @NonNull ConstraintLayout header, @NonNull ConstraintLayout im, @NonNull TextView levelText,
      @NonNull ImageButton profilepicImageButton) {
    this.rootView = rootView;
    this.experiencebarProgressBar4 = experiencebarProgressBar4;
    this.gobackButtonvault = gobackButtonvault;
    this.header = header;
    this.im = im;
    this.levelText = levelText;
    this.profilepicImageButton = profilepicImageButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityVaultBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityVaultBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_vault, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityVaultBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.experiencebar_progressBar4;
      ProgressBar experiencebarProgressBar4 = ViewBindings.findChildViewById(rootView, id);
      if (experiencebarProgressBar4 == null) {
        break missingId;
      }

      id = R.id.goback_buttonvault;
      Button gobackButtonvault = ViewBindings.findChildViewById(rootView, id);
      if (gobackButtonvault == null) {
        break missingId;
      }

      id = R.id.header;
      ConstraintLayout header = ViewBindings.findChildViewById(rootView, id);
      if (header == null) {
        break missingId;
      }

      ConstraintLayout im = (ConstraintLayout) rootView;

      id = R.id.level_text;
      TextView levelText = ViewBindings.findChildViewById(rootView, id);
      if (levelText == null) {
        break missingId;
      }

      id = R.id.profilepic_imageButton;
      ImageButton profilepicImageButton = ViewBindings.findChildViewById(rootView, id);
      if (profilepicImageButton == null) {
        break missingId;
      }

      return new ActivityVaultBinding((ConstraintLayout) rootView, experiencebarProgressBar4,
          gobackButtonvault, header, im, levelText, profilepicImageButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
