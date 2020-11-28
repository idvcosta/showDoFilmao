package com.ingrid.showdofilmao.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.ingrid.showdofilmao.R;
import com.ingrid.showdofilmao.fragments.GameFragment;
import com.ingrid.showdofilmao.fragments.LoadingFragment;
import com.ingrid.showdofilmao.fragments.MenuFragment;
import com.ingrid.showdofilmao.fragments.ResultFragment;
import com.ingrid.showdofilmao.game.GameContract;
import com.ingrid.showdofilmao.game.GamePresenter;

public class GameActivity extends AppCompatActivity implements GameContract.View {

    private GameContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        init();
    }

    @Override
    public void showMenu() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new MenuFragment(presenter)).commit();
    }

    @Override
    public void showLoading() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new LoadingFragment()).commit();
    }

    @Override
    public void showGame() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new GameFragment(presenter)).commit();
    }

    @Override
    public void showResult() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new ResultFragment(presenter)).commit();
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