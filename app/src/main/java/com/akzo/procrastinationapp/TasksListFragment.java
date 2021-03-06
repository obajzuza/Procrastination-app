package com.akzo.procrastinationapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TasksListFragment extends Fragment {
    private TaskDataDao taskDao;
    private Query<TaskData> tasksQuery;
    private  PointsDao pointsDao;

    public TasksListFragment() {
        // Required empty public constructor
    }

    public TasksListFragment(TaskDataDao taskDao, PointsDao pointsDao){
        this.pointsDao = pointsDao;
        this.taskDao = taskDao;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tasks_list, container, false);
//        setContentView(R.layout.fragment_tasks_list);
        tasksQuery = taskDao.queryBuilder().build();
        updateTasks(v);

        return v;
    }

    public void updateTasks(View v){
        List<TaskData> tasks = tasksQuery.list();
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.tasksRecyclerView);
        TaskListAdapter adapter = new TaskListAdapter(tasks, pointsDao, taskDao);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);
    }
}