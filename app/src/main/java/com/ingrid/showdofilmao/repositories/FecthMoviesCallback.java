package com.ingrid.showdofilmao.repositories;

import com.ingrid.showdofilmao.model.Movie;

import java.util.List;

public interface FecthMoviesCallback {
    void onMoviesFecthed(List<Movie> movies);
    void onFecthMoviesFailed(Throwable cause);
}
