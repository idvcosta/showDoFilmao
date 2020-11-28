package com.ingrid.showdofilmao.model;

import android.graphics.Movie;

import java.util.List;

public class Question {

    private Movie movie;
    private List<Option> options;

    public Question(Movie movie, List<Option> options) {
        this.movie = movie;
        this.options = options;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
