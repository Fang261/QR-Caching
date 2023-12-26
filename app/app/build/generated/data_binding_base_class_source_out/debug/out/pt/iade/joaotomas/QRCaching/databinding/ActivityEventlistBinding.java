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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pt.iade.joaotomas.QRCaching.R;

public final class ActivityEventlistBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView eventList;

  @NonNull
  public final ProgressBar experiencebarProgressBar5;

  @NonNull
  public final ConstraintLayout header;

  @NonNull
  public final TextView levelText;

  @NonNull
  public final ImageButton profilepicImageButton;

  private ActivityEventlistBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView eventList, @NonNull ProgressBar experiencebarProgressBar5,
      @NonNull ConstraintLayout header, @NonNull TextView levelText,
      @NonNull ImageButton profilepicImageButton) {
    this.rootView = rootView;
    this.eventList = eventList;
    this.experiencebarProgressBar5 = experiencebarProgressBar5;
    this.header = header;
    this.levelText = levelText;
    this.profilepicImageButton = profilepicImageButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEventlistBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEventlistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_eventlist, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEventlistBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.event_list;
      RecyclerView eventList = ViewBindings.findChildViewById(rootView, id);
      if (eventList == null) {
        break missingId;
      }

      id = R.id.experiencebar_progressBar5;
      ProgressBar experiencebarProgressBar5 = ViewBindings.findChildViewById(rootView, id);
      if (experiencebarProgressBar5 == null) {
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

      id = R.id.profilepic_imageButton;
      ImageButton profilepicImageButton = ViewBindings.findChildViewById(rootView, id);
      if (profilepicImageButton == null) {
        break missingId;
      }

      return new ActivityEventlistBinding((ConstraintLayout) rootView, eventList,
          experiencebarProgressBar5, header, levelText, profilepicImageButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}