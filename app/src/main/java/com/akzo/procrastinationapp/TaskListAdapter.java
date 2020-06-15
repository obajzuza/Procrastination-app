package com.akzo.procrastinationapp;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder>{
    private ArrayList<TaskData> listdata;
    private PointsDao pointsDao;
    private TaskDataDao taskDao;

    // RecyclerView recyclerView;
    public TaskListAdapter(List<TaskData> listdata, PointsDao pointsDao, TaskDataDao taskDao) {
        this.listdata = new ArrayList<>(listdata);
        this.pointsDao = pointsDao;
        this.taskDao = taskDao;
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
                int pointsToAdd = myListData.getPoints();
                List<Points> points = pointsDao.queryBuilder()
                        .where(PointsDao.Properties.Id.eq("main_points"))
                        .list();
                Points currentPoints = points.get(0);
                currentPoints.setPoints(currentPoints.getPoints()+pointsToAdd);
                pointsDao.update(currentPoints);
                Toast.makeText(view.getContext(),"Congrats on finishing: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
                taskDao.delete(myListData);
                listdata.remove(myListData);

                TaskListAdapter.this.notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public void itemClicked(View v){
        String title = ((EditText) v.findViewById(R.id.addTaskTitle)).getText().toString();
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