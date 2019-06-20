package com.ictmcd.poultrykuku;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.RecyclerViewHolder> {

    int previousPosition = 0;
    Context mContext;
    List<data> mData;



    public Adapter(Context mContext, List<data> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.row,viewGroup,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int i) {

        //Jina la ugonjwa
        holder.title.setText(mData.get(i).getTitle());

        //picha ya ugonjwa
        holder.imageView.setImageResource(mData.get(i).getImage());


        //dalili za ugonjwa
        holder.d1.setText(mData.get(i).getDalili1());
        holder.d2.setText(mData.get(i).getDalili2());
        holder.d3.setText(mData.get(i).getDalili3());
        holder.d4.setText(mData.get(i).getDalili4());
        holder.d5.setText(mData.get(i).getDalili5());
        holder.d6.setText(mData.get(i).getDalili6());
        holder.d7.setText(mData.get(i).getDalili7());
        holder.d8.setText(mData.get(i).getDalili8());
        holder.d9.setText(mData.get(i).getDalili9());
        holder.d10.setText(mData.get(i).getDalili10());
        holder.d11.setText(mData.get(i).getDalili11());
        holder.d12.setText(mData.get(i).getDalili12());

        //kinga dhidi ya ugonjwa
        holder.k1.setText(mData.get(i).getKinga1());
        holder.k2.setText(mData.get(i).getKinga2());
        holder.k3.setText(mData.get(i).getKinga3());
        holder.k4.setText(mData.get(i).getKinga4());
        holder.k5.setText(mData.get(i).getKinga5());
        holder.k6.setText(mData.get(i).getKinga6());
        holder.k7.setText(mData.get(i).getKinga7());
        holder.k8.setText(mData.get(i).getKinga8());

        //tiba dhidi ya ugonjwa
        holder.t1.setText(mData.get(i).getTiba1());
        holder.t2.setText(mData.get(i).getTiba2());
        holder.t3.setText(mData.get(i).getTiba3());
        holder.t4.setText(mData.get(i).getTib4());


        if (i > previousPosition){

            AnimationUtil.animate(holder,true);
        }else{
            AnimationUtil.animate(holder,false);
        }

        previousPosition = i;


        holder.playAudioImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imageView;
        TextView d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12;
        TextView k1,k2,k3,k4,k5,k6,k7,k8;
        TextView t1,t2,t3,t4;
        ImageView playAudioImageView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            try {
                title = itemView.findViewById(R.id.title);
                imageView = itemView.findViewById(R.id.img);
                playAudioImageView = itemView.findViewById(R.id.playAudio);
                d1 = itemView.findViewById(R.id.d1);
                d2 = itemView.findViewById(R.id.d2);
                d3 = itemView.findViewById(R.id.d3);
                d4 = itemView.findViewById(R.id.d4);
                d5 = itemView.findViewById(R.id.d5);
                d6 = itemView.findViewById(R.id.d6);
                d7 = itemView.findViewById(R.id.d7);
                d8 = itemView.findViewById(R.id.d8);
                d9 = itemView.findViewById(R.id.d9);
                d10 = itemView.findViewById(R.id.d10);
                d11 = itemView.findViewById(R.id.d11);
                d12 = itemView.findViewById(R.id.d12);


                k1 = itemView.findViewById(R.id.k1);
                k2 = itemView.findViewById(R.id.k2);
                k3 = itemView.findViewById(R.id.k3);
                k4 = itemView.findViewById(R.id.k4);
                k5 = itemView.findViewById(R.id.k5);
                k6 = itemView.findViewById(R.id.k6);
                k7 = itemView.findViewById(R.id.k7);
                k8 = itemView.findViewById(R.id.k8);

                t1 = itemView.findViewById(R.id.t1);
                t2 = itemView.findViewById(R.id.t2);
                t3 = itemView.findViewById(R.id.t3);
                t4 = itemView.findViewById(R.id.t4);
            }catch (Exception e)
            {
                Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }
}
