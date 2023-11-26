package pt.iade.joaotomas.QRCaching.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.R;
import pt.iade.joaotomas.QRCaching.models.eventrow;

public class eventlist_adapter extends RecyclerView.Adapter<eventlist_adapter.ViewHolder> {
    private ArrayList<eventrow> eventrows;
    private LayoutInflater inflater;
    private ItemClickListener clicklistener;

    public eventlist_adapter(Context context, ArrayList<eventrow> items) {
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

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        eventrow item = eventrows.get(position);

        holder.eventname.setText(item.getEventname());


    }

    @Override
    public int getItemCount() {
        return eventrows.size();
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
