package com.ingrid.showdofilmao.repositories;

import android.util.Log;

import com.ingrid.showdofilmao.model.Movie;
import com.ingrid.showdofilmao.repositories.services.AllMoviesResult;
import com.ingrid.showdofilmao.repositories.services.TMDBService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesRepository {

    private static MoviesRepository INSTANCE = null;

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private final TMDBService service;

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

    public void fetchMovies(FecthMoviesCallback fecthMoviesCallback) {
        service.allMovies(Constants.TMDB_KEY_V3).enqueue(new Callback<AllMoviesResult>() {
            @Override
            public void onResponse(Call<AllMoviesResult> call, Response<AllMoviesResult> response) {
                AllMoviesResult allMoviesResult = response.body();
                List<Movie> movieList = allMoviesResult.getMovies();


                fecthMoviesCallback.onMoviesFetched(movieList);
            }

            @Override
            public void onFailure(Call<AllMoviesResult> call, Throwable cause) {
                Log.e("MoviesRepository","fetchMovies error",cause);
                fecthMoviesCallback.onFetchMoviesFailed(cause);
            }
        });
    }

}
