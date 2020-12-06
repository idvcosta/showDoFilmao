package com.ingrid.showdofilmao.game.usecases;

import com.ingrid.showdofilmao.model.Game;
import com.ingrid.showdofilmao.model.Movie;
import com.ingrid.showdofilmao.model.Option;
import com.ingrid.showdofilmao.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoviesListToGameUseCase {


    private int optionsQuantity;

    public MoviesListToGameUseCase(int optionsQuantity) {
        this.optionsQuantity = optionsQuantity;
    }

    public Game execute(List<Movie> movies) {
        List<Question> questions = new ArrayList<>();
        Collections.shuffle(movies);

        List<Movie> chosenMoviesOrder = new ArrayList<>(movies);

        for (Movie movie : chosenMoviesOrder) {
            List<Option> options = createOptions(movie, movies);
            Question question = new Question(movie, options);

            questions.add(question);
        }

        return new Game(questions);
    }

    private List<Option> createOptions(Movie movie, List<Movie> movies) {
        List<Option> options = new ArrayList<>();
        Collections.shuffle(movies);
        List<Movie> selectedMovies = movies.subList(0, optionsQuantity);

        if (!selectedMovies.contains(movie)) {
            selectedMovies.remove(0);
            selectedMovies.add(movie);
        }

        for (Movie selectedMovie : selectedMovies) {
            boolean isCorrectOption = movie.equals(selectedMovie);
            Option option = new Option(selectedMovie, isCorrectOption);
            options.add(option);
        }

        return options;
    }
}
