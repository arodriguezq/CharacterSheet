package com.dexlan.charactersheet.logic.recyclers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dexlan.charactersheet.R;
import com.dexlan.charactersheet.activities.CreationActivity;
import com.dexlan.charactersheet.models.Race;

import java.util.List;

public class RaceRecyclerViewAdapter extends RecyclerView.Adapter<RaceRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Race> mData;

    public RaceRecyclerViewAdapter(Context mContext, List<Race> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.row_race, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mData.get(position).getName());

        int resID = mContext.getResources().getIdentifier(mData.get(position).getMiniature(), "drawable", mContext.getPackageName());
        holder.miniature.setImageResource(resID);

        holder.more_info.setOnClickListener(v -> Snackbar.make(v,String.format("Race '%s' pressed", mData.get(position).getName()), Snackbar.LENGTH_SHORT).show());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, more_info;
        ImageView miniature;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.race_name_row);
            miniature = (ImageView) itemView.findViewById(R.id.race_miniature_row);
            more_info = itemView.findViewById(R.id.race_more_info);
        }
    }
}
