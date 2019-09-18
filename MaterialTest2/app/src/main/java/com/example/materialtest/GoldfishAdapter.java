package com.example.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by lenovo-pc on 2018-09-08.
 */

public class GoldfishAdapter extends RecyclerView.Adapter<GoldfishAdapter.ViewHolder> {
    private Context mContext;
    private List<Goldfish> mGoldfishList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView goldfishImage;
        TextView goldfishName;
        public  ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            goldfishImage = (ImageView) view.findViewById(R.id.goldfish_image);
            goldfishName = (TextView) view.findViewById(R.id.goldfish_name);
        }
    }
    public GoldfishAdapter(List<Goldfish> goldfishList){
        mGoldfishList = goldfishList;
    }

    @Override
    public  ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.goldfish_item,parent,false);
       final  ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Goldfish goldfish = mGoldfishList.get(position);
                Intent intent = new Intent(mContext,GoldfishActivity.class);
                intent.putExtra(GoldfishActivity.GOLDFISH_NAME, goldfish.getName());
                intent.putExtra(GoldfishActivity.GOLDFISH_IMAGE_ID, goldfish.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Goldfish goldfish = mGoldfishList.get(position);
        holder.goldfishName.setText(goldfish.getName());
        Glide.with(mContext).load(goldfish.getImageId()).into(holder.goldfishImage);
    }
    @Override
    public  int getItemCount(){
        return mGoldfishList.size();
    }
}
