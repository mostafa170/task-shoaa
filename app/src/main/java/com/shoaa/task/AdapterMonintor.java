package com.shoaa.task;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shoaa.task.databinding.ItemMonitorBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMonintor extends RecyclerView.Adapter<AdapterMonintor.ViewHolder> {

    public List<ModelMonitor> modelMonitors;
    public Context context;

    public AdapterMonintor(List<ModelMonitor> modelMonitors) {
        this.modelMonitors = modelMonitors;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_monitor, parent, false);

        context = parent.getContext();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final ModelMonitor modelMonitor = modelMonitors.get(position);

        viewHolder.itemMonitorBinding.tvNameShipmentTxt.setText(modelMonitor.getNameOwer());
        viewHolder.itemMonitorBinding.tvPhoneShipmentTxt.setText(modelMonitor.getMonitorName());
        viewHolder.itemMonitorBinding.idFromCity.setText(modelMonitor.getAddress());
        byte[] decodedString = Base64.decode(modelMonitor.getImg1(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        viewHolder.itemMonitorBinding.idAccPhoto.setImageBitmap(decodedByte);
//        Picasso.get()
//                .load(modelMonitor.getImg1())
//                .placeholder(R.drawable.ic_profile_image)
//                .error(android.R.drawable.stat_notify_error)
//                .into(viewHolder.itemMonitorBinding.idAccPhoto);

//        Glide.with(context)
//                .load(modelMonitor.getImg1())
//                .transition(withCrossFade())
//                .fitCenter()
//                .into(viewHolder.itemMonitorBinding.idAccPhoto);
        if (onItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position, modelMonitor);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if (modelMonitors == null)
            return 0;
        return modelMonitors.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ItemMonitorBinding itemMonitorBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bind();
        }


        void bind() {
            if (itemMonitorBinding == null) {
                itemMonitorBinding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if (itemMonitorBinding != null) {
                itemMonitorBinding.unbind();
            }
        }

    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int pos, ModelMonitor modelMonitor);
    }

}
