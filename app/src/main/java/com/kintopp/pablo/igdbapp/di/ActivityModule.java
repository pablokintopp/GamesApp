package com.kintopp.pablo.igdbapp.di;

import com.kintopp.pablo.igdbapp.gamedetail.GameDetailActivity;
import com.kintopp.pablo.igdbapp.gamelist.GameListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector()
    public  abstract GameListActivity contributeGameListActivity();

    @ContributesAndroidInjector()
    public  abstract GameDetailActivity contributeGameDetailActivity();


}
