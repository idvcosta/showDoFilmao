package com.ingrid.showdofilmao.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ingrid.showdofilmao.R;
import com.ingrid.showdofilmao.adapters.OptionsAdapter;
import com.ingrid.showdofilmao.model.Option;
import com.ingrid.showdofilmao.model.Question;

import java.util.List;

public class QuestionFragment extends Fragment {

    private Question question;

    public QuestionFragment(Question question) {
        this.question = question;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        TextView tvTitle =  view.findViewById(R.id.tvTitle);
        RecyclerView rvOptions = view.findViewById(R.id.rvOptions);

        String title  = question.getMovie().getTitle();
        List<Option> options = question.getOptions();

        tvTitle.setText(title);
        rvOptions.setAdapter(new OptionsAdapter(options));

        return view;
    }
}
