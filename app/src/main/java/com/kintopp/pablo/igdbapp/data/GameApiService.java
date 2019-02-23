package com.kintopp.pablo.igdbapp.data;

import com.kintopp.pablo.igdbapp.data.model.Game;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface GameApiService {

    @POST("games")
    Observable<List<Game>> getGames();

//    @POST("genres")
//    Observable<List<Game>> getGenres();
//
//    @POST("covers")
//    Observable<List<Game>> getCovers(List<Game> games);

}
