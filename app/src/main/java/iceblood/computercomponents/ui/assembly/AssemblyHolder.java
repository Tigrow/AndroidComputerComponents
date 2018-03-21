package iceblood.computercomponents.ui.assembly;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import iceblood.computercomponents.R;

/**
 * Holder for Assemblies
 */

class AssemblyHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    TextView name,cpuName,mbName,gpuName;
    AssemblyHolder(View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.assembly_cardview);
        name = itemView.findViewById(R.id.card_assembly_name);
        cpuName = itemView.findViewById(R.id.card_assembly_cpu_name);
        mbName = itemView.findViewById(R.id.card_assembly_mb_name);
        gpuName = itemView.findViewById(R.id.card_assembly_gpu_name);
    }
}
