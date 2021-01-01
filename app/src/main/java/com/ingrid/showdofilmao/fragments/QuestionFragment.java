package com.ingrid.showdofilmao.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ingrid.showdofilmao.R;
import com.ingrid.showdofilmao.adapters.OptionSelectedListener;
import com.ingrid.showdofilmao.adapters.OptionsAdapter;
import com.ingrid.showdofilmao.game.GameMode;
import com.ingrid.showdofilmao.model.Option;
import com.ingrid.showdofilmao.model.Question;

import java.util.List;

import static com.ingrid.showdofilmao.repositories.Constants.TMDB_IMAGES_BASE_URL;

public class QuestionFragment extends Fragment {

    private Question question;
    private OptionSelectedListener optionSelectedListener;
    private GameMode gameMode;
    private ImageView ivCover;

    public QuestionFragment(Question question, OptionSelectedListener optionSelectedListener, GameMode gameMode) {
        this.question = question;
        this.optionSelectedListener = optionSelectedListener;
        this.gameMode = gameMode;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        ivCover =  view.findViewById(R.id.ivCover);
        RecyclerView rvOptions = view.findViewById(R.id.rvOptions);

        List<Option> options = question.getOptions();

        rvOptions.setAdapter(new OptionsAdapter(options, optionSelectedListener, gameMode));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String posterURL = TMDB_IMAGES_BASE_URL + question.getMovie().getPosterURL();
        Glide.with(this).load(posterURL).into(ivCover);
    }
}
