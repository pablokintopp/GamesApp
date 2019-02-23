package com.kintopp.pablo.igdbapp.data;

import com.kintopp.pablo.igdbapp.data.model.Game;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class GameRepository {
    private GameDao gameDao;
    private GameApiService gameApiService;


    public GameRepository(GameDao gameDao, GameApiService gameApiService) {
        this.gameDao = gameDao;
        this.gameApiService = gameApiService;
    }


    public Observable<List<Game>> getGames() {
        return getGamesFromCache().switchIfEmpty(getGamesFromNetwork());
    }

    public Observable<List<Game>> getGamesFromCache() {
        List<Game> games = gameDao.getAllGames();
        if (games == null || games.isEmpty()) {
            return Observable.empty();
        }

        return Observable.just(games);
    }

    public Observable<List<Game>> getGamesFromNetwork() {
        return gameApiService.getGames()
                .concatMap(games -> Observable.just(games))
                .doOnNext(games -> {
                    gameDao.insertGames(games);
                });
    }
}
