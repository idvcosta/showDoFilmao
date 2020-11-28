package com.ingrid.showdofilmao.game;

enum GameState {
    Menu, Loading, Game, Result
}

public class GamePresenter implements GameContract.Presenter {

    private GameContract.View view;
    private GameState state;

    public GamePresenter() {
        state = GameState.Menu;
    }

    @Override
    public void setView(GameContract.View view) {
        this.view = view;

        switch (this.state) {
            case Menu:
                view.showMenu();
                break;
            case Loading:
                view.showLoading();
                break;
            case Game:
                view.showGame();
                break;
            case Result:
                view.showResult();
                break;
        }
    }

    @Override
    public void playClicked() {
        this.state = GameState.Loading;
        if (view != null) {
            view.showLoading();
        }
    }
}
