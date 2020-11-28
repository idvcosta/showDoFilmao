package com.ingrid.showdofilmao.model;

public class Option {

    private Movie movie;
    private boolean isCorrectOption;

    public Option(Movie movie, boolean isCorrectOption) {
        this.movie = movie;
        this.isCorrectOption = isCorrectOption;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public boolean isCorrectOption() {
        return isCorrectOption;
    }

    public void setCorrectOption(boolean correctOption) {
        isCorrectOption = correctOption;
    }
}
