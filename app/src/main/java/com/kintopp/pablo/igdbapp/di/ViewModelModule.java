package com.kintopp.pablo.igdbapp.di;

import com.kintopp.pablo.igdbapp.ViewModelFactory;
import com.kintopp.pablo.igdbapp.data.GameApiService;
import com.kintopp.pablo.igdbapp.data.GameDao;
import com.kintopp.pablo.igdbapp.gamelist.GameListViewModel;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(GameListViewModel.class)
    protected abstract ViewModel gameListViewModel(GameListViewModel gameListViewModel);
}
