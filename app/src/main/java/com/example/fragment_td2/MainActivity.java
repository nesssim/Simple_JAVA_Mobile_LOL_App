package com.example.fragment_td2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button championsButton, spellsButton;
    ImageView menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new MenuFragment());

        championsButton = findViewById(R.id.champions_button);
        spellsButton = findViewById(R.id.spells_button);
        menuButton = findViewById(R.id.ic_info);


        championsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ChampionsFragment());
                spellsButton.setBackgroundColor(getResources().getColor(R.color.lol_purple));
                championsButton.setBackgroundColor(getResources().getColor(R.color.lol_purple_dark));
            }
        });

        spellsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SpellsFragment());
                spellsButton.setBackgroundColor(getResources().getColor(R.color.lol_purple_dark));
                championsButton.setBackgroundColor(getResources().getColor(R.color.lol_purple));;
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new MenuFragment());
                spellsButton.setBackgroundColor(getResources().getColor(R.color.lol_purple));
                championsButton.setBackgroundColor(getResources().getColor(R.color.lol_purple));
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, fragment);
        ft.commit();
    }
}
