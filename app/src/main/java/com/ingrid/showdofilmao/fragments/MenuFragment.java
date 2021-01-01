package com.ingrid.showdofilmao.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ingrid.showdofilmao.R;
import com.ingrid.showdofilmao.game.GameContract;
import com.ingrid.showdofilmao.game.GameMode;

public class MenuFragment extends Fragment {

    private final GameContract.Presenter presenter;

    public MenuFragment(GameContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        view.findViewById(R.id.btPlayByTitle).setOnClickListener(v -> {
            onPlayClicked(GameMode.ByTitle);
        });

        view.findViewById(R.id.btPlayByYear).setOnClickListener(v -> {
            onPlayClicked(GameMode.ByYear);
        });

        return view;
    }

    private void onPlayClicked(GameMode gameMode) {
        presenter.playClicked(gameMode);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
