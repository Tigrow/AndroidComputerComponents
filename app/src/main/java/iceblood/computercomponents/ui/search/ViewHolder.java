package iceblood.computercomponents.ui.search;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import iceblood.computercomponents.R;

/**
 * ViewHolder
 */

class ViewHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    TextView name;
    CheckBox checkBox;

    ViewHolder(View itemView) {
        super(itemView);
        cardView =  itemView.findViewById(R.id.search_cardview);
        name =  itemView.findViewById(R.id.card_name);
        checkBox =  itemView.findViewById(R.id.checkBox);
    }
}
