package com.kintopp.pablo.igdbapp.gamelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.AndroidInjection;

import android.os.Bundle;

import com.kintopp.pablo.igdbapp.R;
import com.kintopp.pablo.igdbapp.ViewModelFactory;
import com.kintopp.pablo.igdbapp.data.model.Game;
import com.kintopp.pablo.igdbapp.databinding.GameListActivityBinding;

import java.util.List;

import javax.inject.Inject;

public class GameListActivity extends AppCompatActivity {

    @Inject
    ViewModelFactory viewModelFactory;


    private GameListViewModel gameListViewModel;
    private GameListActivityBinding binding;
    private GameListAdapter gameListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        initView();
        initViewModel();

    }

    private void initView() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_game_list);
        binding.gamesList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        gameListAdapter = new GameListAdapter(this);
        binding.gamesList.setAdapter(gameListAdapter);

    }

    private void initViewModel() {
        gameListViewModel = ViewModelProviders.of(this, viewModelFactory).get(GameListViewModel.class);
        gameListViewModel.getGamesLiveData().observe(this, games -> {
            if (!games.isEmpty()) {
                updateGamesList(games);
            }
        });

        gameListViewModel.loadGames();
    }

    private void updateGamesList(List<Game> games) {
        gameListAdapter.setItems(games);
    }


}
