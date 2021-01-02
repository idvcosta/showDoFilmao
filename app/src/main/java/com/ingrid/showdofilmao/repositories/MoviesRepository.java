package com.ingrid.showdofilmao.repositories;

import android.service.autofill.FieldClassification;
import android.util.Log;

import com.ingrid.showdofilmao.game.GameMode;
import com.ingrid.showdofilmao.model.Movie;
import com.ingrid.showdofilmao.repositories.services.AllMoviesResult;
import com.ingrid.showdofilmao.repositories.services.TMDBService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRepository {

    private static MoviesRepository INSTANCE = null;

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static final String SORT_BY = "vote_average.desc";
    private final TMDBService service;

    private List<String> genreList = Arrays.asList("16", "35", "18", "10402", "14");

    private MoviesRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(TMDBService.class);

    }

    public static MoviesRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MoviesRepository();
        }

        return INSTANCE;
    }

    public void fetchMovies(GameMode gameMode, FecthMoviesCallback fecthMoviesCallback) {
        switch (gameMode) {
            case ByTitle:
                fetchMoviesByTitle(fecthMoviesCallback);

                break;
            case ByYear:
                fetchMoviesByYear(fecthMoviesCallback);
                break;
        }
    }

    private void fetchMoviesByTitle(FecthMoviesCallback fecthMoviesCallback) {
        String genres = generateGenres();
        int year = generateYear();

        service.allMovies(Constants.TMDB_KEY_V3, genres, year).enqueue(getCallback(fecthMoviesCallback));
    }

    private void fetchMoviesByYear(FecthMoviesCallback fecthMoviesCallback) {
        int minimumReleaseDate = generateMinimumDate();
        service.allMovies2(Constants.TMDB_KEY_V3, minimumReleaseDate, SORT_BY).enqueue(getCallback(fecthMoviesCallback));
    }

    private Callback<AllMoviesResult> getCallback(FecthMoviesCallback fecthMoviesCallback) {
        return new Callback<AllMoviesResult>() {
            @Override
            public void onResponse(Call<AllMoviesResult> call, Response<AllMoviesResult> response) {
                AllMoviesResult allMoviesResult = response.body();
                List<Movie> movieList = allMoviesResult
                        .getMovies()
                        .stream()
                        .filter(movie -> isValid(movie))
                        .collect(Collectors.toList());
                ;

                fecthMoviesCallback.onMoviesFetched(movieList);
            }

            @Override
            public void onFailure(Call<AllMoviesResult> call, Throwable cause) {
                Log.e("MoviesRepository", "fetchMovies error", cause);
                fecthMoviesCallback.onFetchMoviesFailed(cause);
            }
        };
    }

    private boolean isValid(Movie movie) {
        return movie.getYear() != null
                && !movie.getYear().isEmpty()
                && movie.getPosterURL() != null;
    }

    private String generateGenres() {
        int size = genreList.size();
        int selectedIndex = (int) (Math.random() * size);
        return genreList.get(selectedIndex);
    }

    private int generateYear() {
        return 2020;
    }

    private int generateMinimumDate() {
        return 1960 + (int) (Math.random() * 61);
    }

}
