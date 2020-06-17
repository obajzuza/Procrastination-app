package com.akzo.procrastinationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import org.greenrobot.greendao.query.Query;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class PrizesActivity extends AppCompatActivity {
    private PrizeDataDao prizeDao;
    private PointsDao pointsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        prizeDao = daoSession.getPrizeDataDao();
        pointsDao = daoSession.getPointsDao();
        setContentView(R.layout.activity_prizes);
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.prizePlaceholder, new PrizesListFragment(prizeDao, pointsDao));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            ft.replace(R.id.addPrizePlaceholder, new AddPrizeFragment(prizeDao));
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
            ft.replace(R.id.prizePlaceholder, new AddPrizeFragment(prizeDao));
            ft.commit();
        } else if (btn.getText() == getResources().getString(R.string.reject)) {
            btn.setText(R.string.add);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Log.d("UpdatePrize", "test prizes0909909");
            ft.replace(R.id.prizePlaceholder, new PrizesListFragment(prizeDao, pointsDao));
            ft.commit();
        }
    }

}
