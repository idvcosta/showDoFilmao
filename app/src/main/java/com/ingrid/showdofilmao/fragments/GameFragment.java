package com.ingrid.showdofilmao.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.ingrid.showdofilmao.R;
import com.ingrid.showdofilmao.adapters.QuestionsAdapter;
import com.ingrid.showdofilmao.game.GameContract;
import com.ingrid.showdofilmao.model.Game;
import com.ingrid.showdofilmao.model.Question;

public class GameFragment extends Fragment {

    private final GameContract.Presenter presenter;
    private ViewPager2 vpQuestions;

    public GameFragment(GameContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        vpQuestions = view.findViewById(R.id.vpQuestions);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Game game = presenter.getGame();

        vpQuestions.setAdapter(new QuestionsAdapter(game, this));
    }
}
