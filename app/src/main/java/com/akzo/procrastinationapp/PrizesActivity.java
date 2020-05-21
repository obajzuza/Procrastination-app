package com.akzo.procrastinationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrizesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prizes);
        // Begin the transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.prizePlaceholder, new PrizesListFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
    }

    public void switchFragments(View view) {
        Button btn = view.findViewById(R.id.switchButton);
        if (btn.getText() == getResources().getString(R.string.add)) {
            btn.setText(R.string.reject);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.prizePlaceholder, new AddPrizeFragment());
            ft.commit();
        } else if (btn.getText() == getResources().getString(R.string.reject)) {
            btn.setText(R.string.add);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.prizePlaceholder, new PrizesListFragment());
            ft.commit();
        }


    }
}
