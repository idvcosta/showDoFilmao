package com.ingrid.showdofilmao.game;

import com.ingrid.showdofilmao.game.usecases.MoviesListToGameUseCase;
import com.ingrid.showdofilmao.model.Game;
import com.ingrid.showdofilmao.model.Movie;
import com.ingrid.showdofilmao.repositories.FecthMoviesCallback;
import com.ingrid.showdofilmao.repositories.MoviesRepository;

import java.util.List;

enum GameState {
    Menu, Loading, Game, Result
}

public class GamePresenter implements GameContract.Presenter {

    private static final int DEFAULT_OPTIONS_QUANTITY = 4;
    private GameContract.View view;
    private GameState state;

    private MoviesRepository moviesRepository;

    private MoviesListToGameUseCase moviesListToGameUseCase;
    private Game game;

    public GamePresenter() {
        state = GameState.Menu;
        moviesRepository = new MoviesRepository();
        moviesListToGameUseCase = new MoviesListToGameUseCase(DEFAULT_OPTIONS_QUANTITY);
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void setView(GameContract.View view) {
        this.view = view;

        if (view != null) {
            switch (this.state) {
                case Menu:
                    view.showMenu();
                    break;
                case Loading:
                    view.showLoading();
                    break;
                case Game:
                    view.showGame(game);
                    break;
                case Result:
                    view.showResult();
                    break;
            }
        }
    }

    @Override
    public void playClicked() {
        this.state = GameState.Loading;
        if (view != null) {
            view.showLoading();
        }

        new Thread() {
            @Override
            public void run() {
                moviesRepository.fetchMovies(new FecthMoviesCallback() {

                    @Override
                    public void onMoviesFecthed(List<Movie> movies) {
                        game = moviesListToGameUseCase.execute(movies);
                        state = GameState.Game;
                        if (view != null) {
                            view.showGame(game);
                        }
                    }

                    @Override
                    public void onFecthMoviesFailed(Throwable cause) {
//TODO
                    }
                });
            }
        }.start();
    }
}
