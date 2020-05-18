package com.akzo.procrastinationapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Date;

public class TasksListFragment extends Fragment {

    public TasksListFragment() {
        // Required empty public constructor
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
        Date exampleDate = new Date();
        TaskData[] exampleData = new TaskData[] {
                new TaskData("Zadanie 1", "Wykonać zadanie 1, bardzo ważne", 15),
                new TaskData("Zadanie 2", "Wykonać zadanie 2, nie aż tak ważne", 3),
                new TaskData("Projekt 1, część I", "Wykonać część I zadania, notatki w kalendarzu", exampleDate, 30),

        };

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.tasksRecyclerView);
        TaskListAdapter adapter = new TaskListAdapter(exampleData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);

        return v;
    }
}