package com.ingrid.showdofilmao.game;

import com.ingrid.showdofilmao.activities.GameActivity;

public interface GameContract {
    interface View{

        void showMenu();

        void showLoading();

        void showGame();

        void showResult();
    }

    interface Presenter{

        void setView(View view);

        void playClicked();
    }
}
