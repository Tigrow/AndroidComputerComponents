package iceblood.computercomponents.view.search;

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
        cardView = (CardView) itemView.findViewById(R.id.search_cardview);
        name = (TextView) itemView.findViewById(R.id.card_name);
        checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
    }
}
