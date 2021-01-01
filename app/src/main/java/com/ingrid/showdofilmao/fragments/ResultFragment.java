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
import com.ingrid.showdofilmao.model.GameResultType;

public class ResultFragment extends Fragment {

    private final GameContract.Presenter presenter;

    public ResultFragment(GameContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        TextView tvScore = view.findViewById(R.id.tvScore);
        TextView tvResult = view.findViewById(R.id.tvResult);

        int score = presenter.getGame().getCurrentScore();
        GameResultType result = presenter.getGame().getResult();
        int resultMessageId = 0;

        switch (result) {
            case BAD:
                resultMessageId = R.string.message_result_bad;
                break;
            case OK:
                resultMessageId = R.string.message_result_ok;
                break;
            case AWESOME:
                resultMessageId = R.string.message_result_awesome;
                break;
        }

        String scoreMessage = tvScore.getContext().getString(R.string.result_score, score);
        tvScore.setText(scoreMessage);
        tvResult.setText(resultMessageId);

        return view;
    }

}
