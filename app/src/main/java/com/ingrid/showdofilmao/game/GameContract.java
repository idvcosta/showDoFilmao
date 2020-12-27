package com.ingrid.showdofilmao.game;

import com.ingrid.showdofilmao.adapters.OptionSelectedListener;
import com.ingrid.showdofilmao.model.Game;

public interface GameContract {
    interface View{

        void showMenu();

        void showLoading();

        void showGame(Game game);

        void showResult();

        void updateScore(int currentScore);

        void goToNextQuestion();

        void showError();
    }

    interface Presenter extends OptionSelectedListener {

        void setView(View view);

        void playClicked();

        Game getGame();
    }
}
