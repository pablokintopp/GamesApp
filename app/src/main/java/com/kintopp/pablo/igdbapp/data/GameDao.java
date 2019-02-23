package com.kintopp.pablo.igdbapp.data;

import com.kintopp.pablo.igdbapp.data.model.Game;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface GameDao {


    @Insert(onConflict = REPLACE)
    long[] insertGames(List<Game> games);

    @Query("SELECT * FROM 'Game' ")
    List<Game> getAllGames();

}
