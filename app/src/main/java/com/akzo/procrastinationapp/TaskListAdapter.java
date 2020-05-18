package com.akzo.procrastinationapp;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder>{
    private TaskData[] listdata;

    // RecyclerView recyclerView;
    public TaskListAdapter(TaskData[] listdata) {
        this.listdata = listdata;
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
        final TaskData myListData = listdata[position];
        holder.titleTextView.setText(listdata[position].getTitle());
        holder.descriptionTextView.setText(listdata[position].getDescription());
        holder.deadlineTextView.setText(listdata[position].getDeadline());
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