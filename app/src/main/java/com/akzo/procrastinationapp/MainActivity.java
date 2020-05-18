package com.akzo.procrastinationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToTasksList(View view) {
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
    }

    public void goToPrizesList(View view) {
        Intent intent = new Intent(this, PrizesActivity.class);
        startActivity(intent);
    }
}
