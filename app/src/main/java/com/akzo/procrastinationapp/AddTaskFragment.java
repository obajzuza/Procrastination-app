package com.akzo.procrastinationapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskFragment extends Fragment {
    private TaskDataDao taskDao;

    public AddTaskFragment() {
        // Required empty public constructor
    }

    public AddTaskFragment(TaskDataDao taskDao){
        this.taskDao = taskDao;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Dao", "what the task heck3?");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_task, container, false);
        Button btn = (Button) v.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask(v);
            }
        });
        Log.d("Dao", "what the task heck333333?");
        return v;
    }

    public void addTask(View v) {
        String title = ((EditText) getView().findViewById(R.id.addTaskTitle)).getText().toString();
        String description = ((EditText) getView().findViewById(R.id.addTaskDesciption)).getText().toString();
        String deadline = ((EditText) getView().findViewById(R.id.addTaskDeadline)).getText().toString();
        int points = Integer.parseInt(((EditText) getView().findViewById(R.id.addTaskPoints)).getText().toString());
        TaskData task = new TaskData();
        try {
            task.setTitle(title);
            task.setDescription(description);
            task.setDeadline(deadline);
            task.setPoints(points);
            taskDao.insert(task);
        }
        catch (android.database.sqlite.SQLiteConstraintException e){
            Toast toast = Toast.makeText(getActivity(),"Task with this title already exists",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
            toast.show();
        }
        ((EditText) getView().findViewById(R.id.addTaskTitle)).getText().clear();
        ((EditText) getView().findViewById(R.id.addTaskDesciption)).getText().clear();
        ((EditText) getView().findViewById(R.id.addTaskDeadline)).getText().clear();
        ((EditText) getView().findViewById(R.id.addTaskPoints)).getText().clear();

        Toast toast = Toast.makeText(getActivity(),"Task added successfully",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
        toast.show();
        Log.d("DaoExample", "Inserted new task, title: " + task.getTitle());
        getActivity().onBackPressed();
    }
}