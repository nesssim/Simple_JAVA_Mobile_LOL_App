package com.example.fragment_td2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import Module.Champion;

public class ChampionInfoFragment extends Fragment {

    private static final String ARG_CHAMPION = "champion";

    private Champion champion;

    public static ChampionInfoFragment newInstance(Champion champion) {
        ChampionInfoFragment fragment = new ChampionInfoFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_CHAMPION, champion);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            champion = getArguments().getParcelable(ARG_CHAMPION);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champ_info_fragment, container, false);

        ImageView imageView = view.findViewById(R.id.champion_info_image);
        TextView nameTextView = view.findViewById(R.id.champion_info_name);
        TextView roleTextView = view.findViewById(R.id.champion_info_role);

        if (champion != null) {
            imageView.setImageResource(champion.getImageResId());
            nameTextView.setText(champion.getName());
            roleTextView.setText(champion.getRole());
        }

        return view;
    }
}
