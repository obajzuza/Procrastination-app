package com.akzo.procrastinationapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.greendao.query.Query;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrizesListFragment extends Fragment {
    private PrizeDataDao prizeDao;
    private Query<PrizeData> prizesQuery;

    public PrizesListFragment() {
        // Required empty public constructor
    }

    public PrizesListFragment(PrizeDataDao prizeDao){
        this.prizeDao = prizeDao;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_prizes_list, container, false);
//        setContentView(R.layout.fragment_prizes_list);
        Log.d("UpdatePrize", "test prizes33333");
        prizesQuery = prizeDao.queryBuilder().build();
        updatePrizes(v);

        return v;
    }

    public void updatePrizes(View v){
        Log.d("UpdatePrize", "test prizes");
        List<PrizeData> prizes = prizesQuery.list();
        Log.d("UpdatePrize", "test prizes1");
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.prizesRecyclerView);
        Log.d("UpdatePrize", "test prizes2");
        PrizeListAdapter adapter = new PrizeListAdapter(prizes);
        Log.d("UpdatePrize", "test prizes3");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);
    }
}