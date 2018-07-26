package iceblood.computercomponents.ui.assembly;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import iceblood.computercomponents.R;
import iceblood.computercomponents.model.objects.Assembly;

/**
 * it is assemblies adapter
 */

class AssemblyAdapter extends RecyclerView.Adapter<AssemblyHolder> {
    private List<Assembly> assemblies;
    private AssemblyListener listener;

    AssemblyAdapter(List<Assembly> assemblies,AssemblyListener listener){
        this.assemblies = assemblies;
        this.listener = listener;
    }
    @Override
    public AssemblyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_assembly,parent,false);
        return new AssemblyHolder(view);
    }

    @Override
    public void onBindViewHolder(AssemblyHolder holder, int position) {
        holder.name.setText(assemblies.get(position).getName());
        holder.cpuName.setText(assemblies.get(position).getCpuName());
        holder.mbName.setText(assemblies.get(position).getMotherboardName());
        holder.gpuName.setText(assemblies.get(position).getGpuName());
        holder.cardView.setOnClickListener(view -> listener.OnClickView(position));
    }

    @Override
    public int getItemCount() {
        return assemblies.size();
    }
}
