package com.ingrid.showdofilmao.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.ingrid.showdofilmao.R;
import com.ingrid.showdofilmao.fragments.ErrorFragment;
import com.ingrid.showdofilmao.fragments.GameFragment;
import com.ingrid.showdofilmao.fragments.LoadingFragment;
import com.ingrid.showdofilmao.fragments.MenuFragment;
import com.ingrid.showdofilmao.fragments.ResultFragment;
import com.ingrid.showdofilmao.game.GameContract;
import com.ingrid.showdofilmao.game.GamePresenter;
import com.ingrid.showdofilmao.model.Game;

public class GameActivity extends BaseActivity implements GameContract.View {

    private GameContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        init();
    }

    @Override
    public void showMenu() {
        replace(R.id.fragmentContainer, new MenuFragment(presenter));
    }

    @Override
    public void showLoading() {
        replace(R.id.fragmentContainer, new LoadingFragment());
    }

    @Override
    public void showGame(Game game) {
        replace(R.id.fragmentContainer, new GameFragment(presenter));
    }

    @Override
    public void showResult() {
        replace(R.id.fragmentContainer, new ResultFragment(presenter));
    }

    @Override

    public void showError() { replace(R.id.fragmentContainer, new ErrorFragment());
    }

    @Override
    public void updateScore(int currentScore) {
        GameFragment gameFragment = (GameFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        gameFragment.updateScore(currentScore);
    }

    @Override
    public void goToNextQuestion() {
        GameFragment gameFragment = (GameFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        gameFragment.goToNextQuestion();
    }

    private void init() {
        presenter = (GameContract.Presenter) getLastCustomNonConfigurationInstance();

        if (presenter == null) {
            presenter = new GamePresenter();
        }
    }

    @Nullable
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.setView(null);
    }
}