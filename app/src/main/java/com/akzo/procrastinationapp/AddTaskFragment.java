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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Dao", "what the task heck3?");
        View v = inflater.inflate(R.layout.fragment_add_task, container, false);
        Button btn = (Button) v.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask(v);
            }
        });
        Log.d("Dao", "what the task heck3?");
        return v;
    }

    public void addTask(View v) {
        Log.d("Dao", "what the task heck3?");
        String title = ((EditText) getView().findViewById(R.id.addTaskTitle)).getText().toString();
        Log.d("Dao", "what the heck? " + title);
        String description = ((EditText) getView().findViewById(R.id.addTaskDesciption)).getText().toString();
        Log.d("Dao", "what the heck?" + description);
        String deadline = ((EditText) getView().findViewById(R.id.addTaskDeadline)).getText().toString();
        Log.d("Dao", "what the heck?" + description);
        int points = Integer.parseInt(((EditText) getView().findViewById(R.id.addTaskPoints)).getText().toString());
        Log.d("Dao", "what the heck?");

        Log.d("Dao", "what the heck?");
        TaskData task = new TaskData();
        Log.d("Dao", "what the taask heck55?");
        try {
            task.setTitle(title);
            Log.d("Dao", "what the heck55?");
            task.setDescription(description);
            Log.d("Dao", "what the heck55?");
            task.setDeadline(deadline);
            Log.d("Dao", "what the heck55?");
            task.setPoints(points);
            Log.d("DaoExample", "new task" + task);
            taskDao.insert(task);
            Log.d("Dao", "JeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeDUPA");
        }
        catch (android.database.sqlite.SQLiteConstraintException e){
            Toast toast = Toast.makeText(getActivity(),"Task with this title already exists",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
            toast.show();
        }
        Toast toast = Toast.makeText(getActivity(),"Task added successfully",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
        toast.show();
        Log.d("DaoExample", "Inserted new task, title: " + task.getTitle());
        getActivity().onBackPressed();
    }
}
