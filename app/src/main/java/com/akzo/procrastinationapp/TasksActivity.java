package com.akzo.procrastinationapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class TasksActivity extends AppCompatActivity {
    private TaskDataDao taskDao;
    private PointsDao pointsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        taskDao = daoSession.getTaskDataDao();
        pointsDao = daoSession.getPointsDao();
        setContentView(R.layout.activity_tasks);
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.taskPlaceholder, new TasksListFragment(taskDao, pointsDao));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ft.replace(R.id.addTaskPlaceholder, new AddTaskFragment(taskDao));
        }
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
    }

    public void switchFragments(View view) {
        Button btn = view.findViewById(R.id.switchButton);
        if (btn.getText() == getResources().getString(R.string.add)) {
            btn.setText(R.string.reject);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.taskPlaceholder, new AddTaskFragment(taskDao));
            ft.commit();
        } else if (btn.getText() == getResources().getString(R.string.reject)) {
            btn.setText(R.string.add);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.taskPlaceholder, new TasksListFragment(taskDao, pointsDao));
            ft.commit();
        }
    }

}
