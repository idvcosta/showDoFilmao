package com.ingrid.showdofilmao.game;

import com.ingrid.showdofilmao.model.Game;

public interface GameContract {
    interface View{

        void showMenu();

        void showLoading();

        void showGame(Game game);

        void showResult();
    }

    interface Presenter{

        void setView(View view);

        void playClicked();

        Game getGame();
    }
}
