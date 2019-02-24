package com.kintopp.pablo.igdbapp.data;

import com.kintopp.pablo.igdbapp.data.model.Game;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class GameRepository {
    private GameDao gameDao;
    private GameApiService gameApiService;
    private String GAMES_FIELD = "fields category, cover.*, first_release_date, genres.*, name, status, summary, total_rating, total_rating_count; ";
    private String GAMES_SORTING = "sort total_rating desc; ";
    private String GAMES_FILTERS = "where total_rating_count >= 10;";


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
        return gameApiService.getGames(GAMES_FIELD + GAMES_SORTING + GAMES_FILTERS)
                .concatMap(games -> Observable.just(games))
                .subscribeOn(Schedulers.io())
                .doOnNext(games -> {
                    gameDao.insertGames(games);
                })
                .observeOn(AndroidSchedulers.mainThread());

    }
}
