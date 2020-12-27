package com.ingrid.showdofilmao.repositories.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import com.ingrid.showdofilmao.model.Movie;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllMoviesResult {

    @SerializedName("results")
    List<Movie> movies;

    public AllMoviesResult(){

    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

}
