package pt.iade.joaotomas.QRCaching.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.R;
import pt.iade.joaotomas.QRCaching.models.eventrow;

public class eventlist_adaptor extends RecyclerView.Adapter<eventlist_adaptor.ViewHolder> {
    private ArrayList<eventrow> eventrows;
    private LayoutInflater inflater;
    private ItemClickListener clicklistener;

    public eventlist_adaptor(Context context, ArrayList<eventrow> items) {
        inflater = LayoutInflater.from(context);
        eventrows = items;
        clicklistener = null;
    }

    public void setOnClickListener(ItemClickListener listener) {
        clicklistener = listener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_todo_item, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageButton eventname_imageButton;
        public TextView eventname;

        public ViewHolder(View itemView) {
            super(itemView);

            eventname_imageButton = itemView.findViewById(R.id.eventname_imageButton);
            eventname = itemView.findViewById(R.id.eventname);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clicklistener != null) {
                clicklistener.onItemClick(view, getAdapterPosition());
            }
        }
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
