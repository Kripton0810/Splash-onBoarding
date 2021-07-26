package com.kripton.onboardingscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Model> list;

    public Adapter(List<Model> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.page,parent,false); //connect with the layout page
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adapter.ViewHolder holder, int position) {
        String title = list.get(position).getTitle();
        String desc = list.get(position).getDesc();
        int img = list.get(position).getImg();
        holder.setData(title,desc,img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title,desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.titel);
            desc = itemView.findViewById(R.id.desc);
        }
        void setData(String tit,String dec, int imgres)
        {
            title.setText(tit);
            desc.setText(dec);
            image.setImageResource(imgres);
        }

    }
}
