package pt.iade.joaotomas.QRCaching.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.joaotomas.QRCaching.R;
import pt.iade.joaotomas.QRCaching.models.QrcodeItem;
import pt.iade.joaotomas.QRCaching.profilepage;

public class qrcodelist_adapter extends RecyclerView.Adapter<qrcodelist_adapter.ViewHolder> {
    private ArrayList<QrcodeItem> qrcodeItems;
    private LayoutInflater inflater;
    private qrcodelist_adapter.ItemClickListener clicklistener;

    public qrcodelist_adapter(profilepage profilepage, ArrayList<QrcodeItem> items) {
        inflater = LayoutInflater.from(profilepage);
        qrcodeItems = items;

        clicklistener = null;
    }

    public void setOnClickListener(ItemClickListener listener) { clicklistener = listener; }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_qrcode_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(qrcodelist_adapter.ViewHolder holder, int position) {
        QrcodeItem item = qrcodeItems.get(position);

    }

    @Override
    public int getItemCount() {
        return qrcodeItems.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView qrcode_imageView;
        public TextView qrcode_streename_textView;

        public ViewHolder(View itemView) {
            super(itemView);

            qrcode_imageView = itemView.findViewById(R.id.qrcode_imageView);
            qrcode_streename_textView = itemView.findViewById(R.id.qrcode_streename_textView);

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
