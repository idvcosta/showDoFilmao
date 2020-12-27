package com.ingrid.showdofilmao.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ingrid.showdofilmao.fragments.QuestionFragment;
import com.ingrid.showdofilmao.model.Game;
import com.ingrid.showdofilmao.model.Question;

public class QuestionsAdapter extends FragmentStateAdapter {

    private Game game;
    private OptionSelectedListener optionSelectedListener;

    public QuestionsAdapter(Game game, Fragment parent, OptionSelectedListener optionSelectedListener) {
        super(parent);

        this.game = game;
        this.optionSelectedListener = optionSelectedListener;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Question question = game.getQuestion(position);

        return new QuestionFragment(question, optionSelectedListener);
    }

    @Override
    public int getItemCount() {
        return game.getQuestionsCount();
    }
}
