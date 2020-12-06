package com.ingrid.showdofilmao.model;

import java.util.List;

public class Game {
    private static final int SCORE_INCREASE = 10;

    private List<Question> questions;
    private int score;
    private int currentQuestionIndex = 0;

    public Game(List<Question> questions){
        this.questions = questions;
    }

    public int getCurrentScore(){
        return score;
    }

    public void increaseScore(){
        score = score + SCORE_INCREASE;
    }

    public int getCurrentQuestionIndex(){
        return currentQuestionIndex + 1;
    }

    public int getQuestionsCount(){
        return questions.size();
    }

    public void goToNextQuestion(){
        currentQuestionIndex++;
    }

    public Question getCurrentQuestion(){
        return questions.get(currentQuestionIndex);
    }
}
