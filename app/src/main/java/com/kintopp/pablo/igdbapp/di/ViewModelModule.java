package com.kintopp.pablo.igdbapp.di;

import com.kintopp.pablo.igdbapp.data.GameApiService;
import com.kintopp.pablo.igdbapp.data.GameDao;
import com.kintopp.pablo.igdbapp.gamelist.GameListViewModel;


import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

    @Provides
    public GameListViewModel provideGameListViewModel(GameDao gameDao, GameApiService gameApiService){
        return new GameListViewModel(gameDao, gameApiService);
    }
}
