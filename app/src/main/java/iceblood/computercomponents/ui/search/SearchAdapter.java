package iceblood.computercomponents.ui.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import iceblood.computercomponents.R;
import iceblood.computercomponents.model.objects.SimpleProcessor;

/**
 * RecyclerViewAdapter to SearchActivity
 */

public class SearchAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<SimpleProcessor> simpleProcessors;
    private Listener listener;

    public SearchAdapter(List<SimpleProcessor> simpleProcessors) {
        this.simpleProcessors = simpleProcessors;
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_processor, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(simpleProcessors.get(position).getName());
        holder.checkBox.setChecked(simpleProcessors.get(position).isLiked());
        holder.checkBox.setOnClickListener(view -> {
            simpleProcessors.get(position).setLiked(holder.checkBox.isChecked());
            listener.OnClickChechBox(position, holder.checkBox.isChecked());
        });
        holder.cardView.setOnClickListener(view -> listener.OnClickView(simpleProcessors.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return simpleProcessors.size();
    }

}

