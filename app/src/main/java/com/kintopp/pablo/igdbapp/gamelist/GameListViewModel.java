package com.kintopp.pablo.igdbapp.gamelist;

import com.kintopp.pablo.igdbapp.data.model.Game;
import com.kintopp.pablo.igdbapp.data.GameApiService;
import com.kintopp.pablo.igdbapp.data.GameDao;
import com.kintopp.pablo.igdbapp.data.GameRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameListViewModel extends ViewModel {

    private GameRepository gameRepository;

    private MutableLiveData<List<Game>> gamesLiveData = new MutableLiveData<>();

    @Inject
    public GameListViewModel(GameDao gameDao, GameApiService gameApiService) {
        gameRepository = new GameRepository(gameDao, gameApiService);
    }

    public void loadGames(){
        gameRepository.getGames()
                .subscribe(games -> { gamesLiveData.postValue(games);});
    }

    public MutableLiveData<List<Game>> getGamesLiveData() {
        return gamesLiveData;
    }
}
