// Generated by view binder compiler. Do not edit!
package pt.iade.joaotomas.QRCaching.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class ActivityMainpageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton btnScan;

  @NonNull
  public final ImageButton eventsImageButton;

  @NonNull
  public final TextView eventsTextView;

  @NonNull
  public final ProgressBar experiencebarProgressBar;

  @NonNull
  public final ConstraintLayout header;

  @NonNull
  public final TextView levelText;

  @NonNull
  public final ImageButton mapImageButton;

  @NonNull
  public final TextView mapTextView4;

  @NonNull
  public final ImageButton profilepicImageButton;

  private ActivityMainpageBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton btnScan,
      @NonNull ImageButton eventsImageButton, @NonNull TextView eventsTextView,
      @NonNull ProgressBar experiencebarProgressBar, @NonNull ConstraintLayout header,
      @NonNull TextView levelText, @NonNull ImageButton mapImageButton,
      @NonNull TextView mapTextView4, @NonNull ImageButton profilepicImageButton) {
    this.rootView = rootView;
    this.btnScan = btnScan;
    this.eventsImageButton = eventsImageButton;
    this.eventsTextView = eventsTextView;
    this.experiencebarProgressBar = experiencebarProgressBar;
    this.header = header;
    this.levelText = levelText;
    this.mapImageButton = mapImageButton;
    this.mapTextView4 = mapTextView4;
    this.profilepicImageButton = profilepicImageButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainpageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainpageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_mainpage, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainpageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_scan;
      ImageButton btnScan = ViewBindings.findChildViewById(rootView, id);
      if (btnScan == null) {
        break missingId;
      }

      id = R.id.events_imageButton;
      ImageButton eventsImageButton = ViewBindings.findChildViewById(rootView, id);
      if (eventsImageButton == null) {
        break missingId;
      }

      id = R.id.events_textView;
      TextView eventsTextView = ViewBindings.findChildViewById(rootView, id);
      if (eventsTextView == null) {
        break missingId;
      }

      id = R.id.experiencebar_progressBar;
      ProgressBar experiencebarProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (experiencebarProgressBar == null) {
        break missingId;
      }

      id = R.id.header;
      ConstraintLayout header = ViewBindings.findChildViewById(rootView, id);
      if (header == null) {
        break missingId;
      }

      id = R.id.level_text;
      TextView levelText = ViewBindings.findChildViewById(rootView, id);
      if (levelText == null) {
        break missingId;
      }

      id = R.id.map_imageButton;
      ImageButton mapImageButton = ViewBindings.findChildViewById(rootView, id);
      if (mapImageButton == null) {
        break missingId;
      }

      id = R.id.map_textView4;
      TextView mapTextView4 = ViewBindings.findChildViewById(rootView, id);
      if (mapTextView4 == null) {
        break missingId;
      }

      id = R.id.profilepic_imageButton;
      ImageButton profilepicImageButton = ViewBindings.findChildViewById(rootView, id);
      if (profilepicImageButton == null) {
        break missingId;
      }

      return new ActivityMainpageBinding((ConstraintLayout) rootView, btnScan, eventsImageButton,
          eventsTextView, experiencebarProgressBar, header, levelText, mapImageButton, mapTextView4,
          profilepicImageButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}