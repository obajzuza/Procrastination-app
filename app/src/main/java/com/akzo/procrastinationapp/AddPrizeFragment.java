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
import android.widget.Switch;
import android.widget.Toast;

public class AddPrizeFragment extends Fragment {
    private PrizeDataDao prizeDao;

    public AddPrizeFragment() {
        // Required empty public constructor
    }

    public AddPrizeFragment(PrizeDataDao prizeDao){
        this.prizeDao = prizeDao;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Dao", "what the heck222222?");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_prize, container, false);

        Button btn = (Button) v.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPrize(v);
            }
        });
        return v;
    }

    public void addPrize(View view) {
        Log.d("Dao", "what the task heck3?");
        Log.d("Dao", "what the heck3?");
        String title = ((EditText) getView().findViewById(R.id.addPrizeTitle)).getText().toString();
        Log.d("Dao", "what the heck? " + title);
        String description = ((EditText) getView().findViewById(R.id.addPrizeDesciption)).getText().toString();
        Log.d("Dao", "what the heck?" + description);
        int points = Integer.parseInt(((EditText) getView().findViewById(R.id.addPrizePoints)).getText().toString());
        Log.d("Dao", "what the heck?");
        boolean isPersistent = ((Switch) getView().findViewById(R.id.switch1)).isChecked();

        Log.d("Dao", "what the heck?");
        PrizeData prize = new PrizeData();
        Log.d("Dao", "what the heck55?");
        try {
            prize.setTitle(title);
            prize.setDescription(description);
            prize.setPoints(points);
            prize.setIsPersistent(isPersistent);
            Log.d("DaoExample", "new prize" + prize);
            prizeDao.insert(prize);
        }
        catch (android.database.sqlite.SQLiteConstraintException e){
            Toast toast = Toast.makeText(getActivity(),"Prize with this title already exists",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
            toast.show();
        }
        Toast toast = Toast.makeText(getActivity(),"Prize added successfully",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
        toast.show();
        Log.d("DaoExample", "Inserted new prize, title: " + prize.getTitle());
        getActivity().onBackPressed();
    }
}
