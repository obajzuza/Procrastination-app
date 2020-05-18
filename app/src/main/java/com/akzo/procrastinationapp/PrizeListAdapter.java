package com.akzo.procrastinationapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class PrizeListAdapter extends RecyclerView.Adapter<PrizeListAdapter.ViewHolder>{
    private PrizeData[] listdata;

    // RecyclerView recyclerView;
    public PrizeListAdapter(PrizeData[] listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item_prize, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PrizeData myListData = listdata[position];
        holder.titleTextView.setText(listdata[position].getTitle());
        holder.descriptionTextView.setText(listdata[position].getDescription());
        holder.pointsTextView.setText(Integer.toString(listdata[position].getPoints()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show(); // TODO
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView pointsTextView;
        public TextView titleTextView;
        public TextView descriptionTextView;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.pointsTextView = (TextView) itemView.findViewById(R.id.pointsTextView);
            this.titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            this.descriptionTextView = (TextView) itemView.findViewById(R.id.descriptionTextView);

            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.prizeLayout);
        }
    }
}