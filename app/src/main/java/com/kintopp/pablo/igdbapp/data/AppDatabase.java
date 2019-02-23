package com.kintopp.pablo.igdbapp.data;

import com.kintopp.pablo.igdbapp.data.converter.CoverTypeConverter;
import com.kintopp.pablo.igdbapp.data.converter.GenreListTypeConverter;
import com.kintopp.pablo.igdbapp.data.model.Game;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Game.class}, version = 1, exportSchema = false)
@TypeConverters({GenreListTypeConverter.class, CoverTypeConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract GameDao gameDao();
}
