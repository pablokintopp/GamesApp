package com.kintopp.pablo.igdbapp.data;

import com.kintopp.pablo.igdbapp.data.model.Cover;
import com.kintopp.pablo.igdbapp.data.model.Game;
import com.kintopp.pablo.igdbapp.data.model.Genre;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Game.class, Genre.class, Cover.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GameDao gameDao();
}
