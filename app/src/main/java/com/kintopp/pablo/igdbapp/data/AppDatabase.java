package com.kintopp.pablo.igdbapp.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Game.class, Genre.class, Cover.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GameDao gameDao();
}
