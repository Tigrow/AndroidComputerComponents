package iceblood.computercomponents.view.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import iceblood.computercomponents.R;
import iceblood.computercomponents.model.objects.SimpleProcessor;

/**
 * Created by Titan'ik on 08.02.2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private List<SimpleProcessor> simpleProcessors;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this cas
        TextView name;
        TextView codeName;
        TextView cores;
        TextView threads;

        ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.card_name);
            codeName = (TextView) itemView.findViewById(R.id.card_codename);
            cores = (TextView) itemView.findViewById(R.id.card_cores);
            threads = (TextView) itemView.findViewById(R.id.card_threads);

        }
    }

    public SearchAdapter(Context context,List<SimpleProcessor> simpleProcessors) {
        this.context = context;
        this.simpleProcessors = simpleProcessors;
    }
    /*public void setSearched(List<SimpleProcessor> simple){
        simpleProcessors = simple;
    }*/

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_processor, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.name.setText(simpleProcessors.get(position).getName());
        holder.codeName.setText(simpleProcessors.get(position).getCodename());
        holder.threads.setText(context.getString(R.string.Threads)+ " " +Integer.toString(simpleProcessors.get(position).getThreads()));
        holder.cores.setText(context.getString(R.string.Cores) + " " + Integer.toString(simpleProcessors.get(position).getCores()));


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return simpleProcessors.size();
    }
}

