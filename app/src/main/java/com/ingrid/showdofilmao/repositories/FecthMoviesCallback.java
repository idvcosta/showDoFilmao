package com.ingrid.showdofilmao.repositories;

import com.ingrid.showdofilmao.model.Movie;

import java.util.List;

public interface FecthMoviesCallback {
    void onMoviesFetched(List<Movie> movies);
    void onFetchMoviesFailed(Throwable cause);
}
