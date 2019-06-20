package com.ictmcd.poultrykuku;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class fragment2_item_adapter extends RecyclerView.Adapter<fragment2_item_adapter.myViewHolder> {

    int previousPosition = 0;
    Context mContext;
    List<fragement2_Item> mData;

    public fragment2_item_adapter(Context mContext, List<fragement2_Item> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.fragment2_list_items,viewGroup,false);


        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int i) {

        holder.image.setImageResource(mData.get(i).getImage());
        holder.Head.setText(mData.get(i).getHead());
        holder.Desc.setText(mData.get(i).getDesc());

        if (i > previousPosition){

            AnimationUtil.animate(holder,true);
        }else{
            AnimationUtil.animate(holder,false);
        }

        previousPosition = i;

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends  RecyclerView.ViewHolder{

        ImageView image;
        TextView Head;
        TextView Desc;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.img);
            Head = itemView.findViewById(R.id.txtHead);
            Desc = itemView.findViewById(R.id.txtDesc);


        }
    }


}
