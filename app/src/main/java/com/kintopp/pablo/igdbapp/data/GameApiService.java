package com.kintopp.pablo.igdbapp.data;

import com.kintopp.pablo.igdbapp.data.model.Game;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GameApiService {

//    @Headers("Content-Type: text/plain; charset=UTF-8")
    @POST("games")
    Observable<List<Game>> getGames(@Body String query);

//    @POST("genres")
//    Observable<List<Game>> getGenres();
//
//    @POST("covers")
//    Observable<List<Game>> getCovers(List<Game> games);

}
