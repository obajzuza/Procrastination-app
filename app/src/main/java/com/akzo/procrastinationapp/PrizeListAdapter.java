package com.akzo.procrastinationapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PrizeListAdapter extends RecyclerView.Adapter<PrizeListAdapter.ViewHolder>{
    private ArrayList<PrizeData> listdata;
    private PointsDao pointsDao;
    private PrizeDataDao prizeDao;

    // RecyclerView recyclerView;
    public PrizeListAdapter(List<PrizeData> listdata, PointsDao pointsDao, PrizeDataDao prizeDao) {
        this.listdata = new ArrayList<>(listdata);
        this.pointsDao = pointsDao;
        this.prizeDao = prizeDao;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item_prize, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final PrizeData myListData = listdata.get(position);
        holder.titleTextView.setText(listdata.get(position).getTitle());
        holder.descriptionTextView.setText(listdata.get(position).getDescription());
        holder.pointsTextView.setText(Integer.toString(listdata.get(position).getPoints()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pointsToSubtract = myListData.getPoints();
                List<Points> points = pointsDao.queryBuilder()
                        .where(PointsDao.Properties.Id.eq("main_points"))
                        .list();
                Points currentPoints = points.get(0);

                if(currentPoints.getPoints()-pointsToSubtract<0){
                    Toast.makeText(view.getContext(),"Sorry you don't have enough points",Toast.LENGTH_LONG).show();
                }else{
                    currentPoints.setPoints(currentPoints.getPoints()-pointsToSubtract);
                    pointsDao.update(currentPoints);
                    Toast.makeText(view.getContext(),"You chose: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
                    if(!myListData.getIsPersistent()){
                        prizeDao.delete(myListData);
                        listdata.remove(myListData);

                        PrizeListAdapter.this.notifyDataSetChanged();
                    }

                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
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