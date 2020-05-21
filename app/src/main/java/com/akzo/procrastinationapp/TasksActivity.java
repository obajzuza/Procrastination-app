package com.akzo.procrastinationapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class TasksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.taskPlaceholder, new TasksListFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
    }

    public void switchFragments(View view) {
        Button btn = view.findViewById(R.id.switchButton);
        if (btn.getText() == getResources().getString(R.string.add)) {
            btn.setText(R.string.reject);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.taskPlaceholder, new AddTaskFragment());
            ft.commit();
        } else if (btn.getText() == getResources().getString(R.string.reject)) {
            btn.setText(R.string.add);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.taskPlaceholder, new TasksListFragment());
            ft.commit();
        }
    }

}
