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
import com.ingrid.showdofilmao.adapters.OptionSelectedListener;
import com.ingrid.showdofilmao.adapters.QuestionsAdapter;
import com.ingrid.showdofilmao.game.GameContract;
import com.ingrid.showdofilmao.model.Game;
import com.ingrid.showdofilmao.model.Question;

public class GameFragment extends Fragment {

    private final GameContract.Presenter presenter;
    private ViewPager2 vpQuestions;
    private TextView tvScore;
    private TextView tvStep;
    private int stepTotal;

    public GameFragment(GameContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        vpQuestions = view.findViewById(R.id.vpQuestions);
        tvScore = view.findViewById(R.id.tvScore);
        tvStep = view.findViewById(R.id.tvStep);

        updateScore(0);
        vpQuestions.setUserInputEnabled(false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Game game = presenter.getGame();
        stepTotal = game.getQuestionsCount();
        setCurrentStep(1);

        vpQuestions.setAdapter(new QuestionsAdapter(game, this, presenter));
    }

    private void setCurrentStep(int currentStep) {
        tvStep.setText(currentStep + " / " + stepTotal);
    }

    public void updateScore(int currentScore) {
        tvScore.setText(currentScore + " pontos");
    }

    public void goToNextQuestion() {
        int nextPosition = vpQuestions.getCurrentItem() + 1;
        vpQuestions.setCurrentItem(nextPosition);

        setCurrentStep(nextPosition + 1);
    }
}
