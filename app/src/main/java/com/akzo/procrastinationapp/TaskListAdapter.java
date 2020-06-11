package com.akzo.procrastinationapp;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder>{
    private ArrayList<TaskData> listdata;

    // RecyclerView recyclerView;
    public TaskListAdapter(List<TaskData> listdata) {
        this.listdata = new ArrayList<>(listdata);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item_task, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TaskData myListData = listdata.get(position);
        holder.titleTextView.setText(listdata.get(position).getTitle());
        holder.descriptionTextView.setText(listdata.get(position).getDescription());
        holder.deadlineTextView.setText(listdata.get(position).getDeadline());
        holder.pointsTextView.setText(Integer.toString(listdata.get(position).getPoints()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show(); // TODO
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView descriptionTextView;
        public TextView deadlineTextView;
        public TextView pointsTextView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.titleTextView = (TextView) itemView.findViewById(R.id.titleTextView);
            this.descriptionTextView = (TextView) itemView.findViewById(R.id.descriptionTextView);
            this.deadlineTextView = (TextView) itemView.findViewById(R.id.deadlineTextView);
            this.pointsTextView = (TextView) itemView.findViewById(R.id.pointsTextView);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.taskLayout);
        }
    }
}