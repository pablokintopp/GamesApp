package com.kintopp.pablo.igdbapp.gamedetail;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.kintopp.pablo.igdbapp.R;

import com.kintopp.pablo.igdbapp.data.model.Game;
import com.kintopp.pablo.igdbapp.databinding.GameDetailActivityBinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;


public class GameDetailActivity extends AppCompatActivity {
    public static String INTENT_GAME = "com.kintopp.pablo.igdbapp.data.model.Game.intent";
    private Game game;
    private GameDetailActivityBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initialiseView();
    }

    private void initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_detail);
        game = getIntent().getParcelableExtra(INTENT_GAME);
        Glide.with(this).load(game.getCover().getFormatedUrl()).into(binding.gameImage);
        try {
//            binding.gameName.setText(game.getName());
            binding.gameSummary.setText(game.getSummary());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setToolbar();


    }

    private void setToolbar() {

        binding.collapsingToolbar.setContentScrimColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        binding.collapsingToolbar.setTitle(game.getName());
        binding.collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedToolbar);
        binding.collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedToolbar);
        binding.collapsingToolbar.setTitleEnabled(true);

        if (binding.toolbar != null) {
            this.setSupportActionBar(binding.toolbar);


            ActionBar actionBar = this.getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        } else {
            // landscape
        }
    }
}
