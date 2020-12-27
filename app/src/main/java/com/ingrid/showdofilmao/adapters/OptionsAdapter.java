package com.ingrid.showdofilmao.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ingrid.showdofilmao.R;
import com.ingrid.showdofilmao.model.Option;

import java.util.List;

public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.OptionHolder> {

    class OptionHolder extends RecyclerView.ViewHolder {
        private Button btOption;

        public OptionHolder(@NonNull View itemView, Button btOption) {
            super(itemView);
            this.btOption = btOption;
        }
    }

    private List<Option> options;
    private OptionSelectedListener optionSelectedListener;

    public OptionsAdapter(List<Option> options, OptionSelectedListener optionSelectedListener) {
        this.options = options;
        this.optionSelectedListener = optionSelectedListener;
    }

    @NonNull
    @Override
    public OptionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_option, parent, false);
        Button btOption = view.findViewById(R.id.btOption);
        btOption.setOnClickListener(source -> {
            Option option = (Option) source.getTag();
             optionSelectedListener.onOptionSelected(option);
        });

        OptionHolder holder = new OptionHolder(view, btOption);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OptionHolder holder, int position) {
        Option option = options.get(position);

        holder.btOption.setText(option.getMovie().getTitle());
        holder.btOption.setTag(option);
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

}
