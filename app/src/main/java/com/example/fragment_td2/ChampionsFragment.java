package com.example.fragment_td2;

import RecyclerView.ChampionAdapter;
import Module.Champion;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChampionsFragment extends Fragment implements ChampionAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ChampionAdapter adapter;
    private List<Champion> championList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_champions, container, false);

        recyclerView = view.findViewById(R.id.champions_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize champion list
        championList = Champion.getChampList();

        // Set up the adapter
        adapter = new ChampionAdapter(getContext(), championList, this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(Champion champion) {
        ChampionInfoFragment fragment = ChampionInfoFragment.newInstance(champion);
        getParentFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}