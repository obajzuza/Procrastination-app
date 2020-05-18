package com.akzo.procrastinationapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrizesListFragment extends Fragment {

    public PrizesListFragment() {
        // Required empty public constructor
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
        PrizeData[] exampleData = new PrizeData[] {
                new PrizeData("Nagroda 1", "15 min robienia aktywności jak w tytule", 15, false),
                new PrizeData("Nagroda 2", "", 50, false),
                new PrizeData("Nagroda 3", "opis nagrody", 6, false)
        };

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.prizesRecyclerView);
        PrizeListAdapter adapter = new PrizeListAdapter(exampleData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);

        return v;
    }
}