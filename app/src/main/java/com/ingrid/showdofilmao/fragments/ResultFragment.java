package com.ingrid.showdofilmao.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ingrid.showdofilmao.R;
import com.ingrid.showdofilmao.game.GameContract;

public class ResultFragment extends Fragment {

    private final GameContract.Presenter presenter;
    private TextView tvResult;

    public ResultFragment(GameContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        tvResult = view.findViewById(R.id.tvResult);
        int score = presenter.getGame().getCurrentScore();
        tvResult.setText("Sua pontuação foi: " + score);

        return view;
    }

}
