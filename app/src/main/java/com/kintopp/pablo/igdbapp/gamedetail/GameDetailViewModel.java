package com.kintopp.pablo.igdbapp.gamedetail;

import com.kintopp.pablo.igdbapp.data.model.Game;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameDetailViewModel extends ViewModel {

    private MutableLiveData<Game> gameLiveData = new MutableLiveData<>();

    @Inject
    public GameDetailViewModel() {
    }

    public MutableLiveData<Game> getGameLiveData() {
        return gameLiveData;
    }
}

