package com.akzo.procrastinationapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import org.greenrobot.greendao.database.Database;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
    boolean learningMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop(){
        super.onStop();
        if(learningMode) unregisterReceiver(networkChangeReceiver);
    }

    public void goToTasksList(View view) {
        Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
    }

    public void goToPrizesList(View view) {
        Intent intent = new Intent(this, PrizesActivity.class);
        startActivity(intent);
    }

    public void switchLearningMode(View view){
        learningMode = !learningMode;
        if (learningMode) {
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(networkChangeReceiver, filter);
        }
        else{
            unregisterReceiver(networkChangeReceiver);
        }
    }

}
