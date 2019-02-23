package com.kintopp.pablo.igdbapp.di;

import android.app.Application;

import com.kintopp.pablo.igdbapp.data.AppDatabase;
import com.kintopp.pablo.igdbapp.data.GameDao;


import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    public final String DB_NAME = "Games.db";

    @Provides
    @Singleton
    AppDatabase provideDatabase(@NonNull Application application){
        return Room.databaseBuilder(application,AppDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public GameDao provideGameDao(@NonNull AppDatabase appDatabase){
        return appDatabase.gameDao();
    }
}
