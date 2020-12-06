package com.ingrid.showdofilmao.activities;

import android.os.Bundle;

import com.ingrid.showdofilmao.R;
import com.ingrid.showdofilmao.fragments.GameFragment;
import com.ingrid.showdofilmao.fragments.LoadingFragment;
import com.ingrid.showdofilmao.fragments.MenuFragment;
import com.ingrid.showdofilmao.fragments.ResultFragment;
import com.ingrid.showdofilmao.game.GameContract;
import com.ingrid.showdofilmao.game.GamePresenter;

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
    public void showGame() {
        replace(R.id.fragmentContainer, new GameFragment(presenter));
    }

    @Override
    public void showResult() {
        replace(R.id.fragmentContainer, new ResultFragment(presenter));
    }

    private void init() {
        presenter = (GameContract.Presenter) getLastCustomNonConfigurationInstance();

        if (presenter == null) {
            presenter = new GamePresenter();
        }
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