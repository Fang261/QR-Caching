package pt.iade.joaotomas.QRCaching.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.R;
import pt.iade.joaotomas.QRCaching.models.PhotoItem;
import pt.iade.joaotomas.QRCaching.vault;

public class photolist_adapter extends RecyclerView.Adapter<photolist_adapter.ViewHolder> {
    private ArrayList<PhotoItem> photoItems;
    private LayoutInflater inflater;
    private photolist_adapter.ItemClickListener clicklistener;

    public photolist_adapter(vault vault, ArrayList<PhotoItem> itemList) {
        inflater = LayoutInflater.from(vault);
        photoItems = itemList;

        clicklistener = null;
    }

    public void setOnClickListener(photolist_adapter.ItemClickListener listener) { clicklistener = listener; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_event_item, parent, false);
        return new photolist_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(photolist_adapter.ViewHolder holder, int position) {
        PhotoItem item = photoItems.get(position);

    }

    @Override
    public int getItemCount() {
        return photoItems.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageButton photo_imageButton;

        public ViewHolder(View itemView) {
            super(itemView);

            photo_imageButton = itemView.findViewById(R.id.photo_imageButton);

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
