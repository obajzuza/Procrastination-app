package com.akzo.procrastinationapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.greendao.database.Database;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
    boolean learningMode = false;
    private PointsDao pointsDao;
    public int currentPoints;
    public int numberOfTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        pointsDao = daoSession.getPointsDao();
        TaskDataDao taskDao = daoSession.getTaskDataDao();
        List<Points> points = pointsDao.queryBuilder().build().list();
        if(points==null || points.size()==0){
            Log.d("Points", "YEEEEEEEEEEEEEEEEEEY");
            Points currentPoints = new Points();
            currentPoints.setPoints(0);
            Log.d("Points", "pointssssss");
            pointsDao.insert(currentPoints);
            points = pointsDao.queryBuilder().build().list();
            Log.d("Points", "pointssss "+points.toString());
            this.currentPoints = currentPoints.getPoints();
        }
        else {
            this.currentPoints = points.get(0).getPoints();
        }

        TextView textView = (TextView) findViewById(R.id.pointsNumberTextView);
        textView.setText(Integer.toString(this.currentPoints));
        numberOfTasks = 0;
        List<TaskData> tasks = taskDao.queryBuilder().build().list();
        if(tasks!=null){
            numberOfTasks = tasks.size();
        }
        TextView taskTextView = findViewById((R.id.tasksNumberTextView));
        taskTextView.setText(Integer.toString(numberOfTasks));


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
