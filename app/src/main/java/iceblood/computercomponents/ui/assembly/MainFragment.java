package iceblood.computercomponents.ui.assembly;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import iceblood.computercomponents.R;
import iceblood.computercomponents.model.Constants;
import iceblood.computercomponents.PresenterManager;
import iceblood.computercomponents.ui.base.BaseFragment;
import iceblood.computercomponents.ui.search.SearchActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment<AssemblyPresenter> implements AssemblyView {

    private AssemblyAdapter assemblyAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private View view;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            presenter = new AssemblyPresenter();
        } else {
            presenter = PresenterManager.getInstance().restorePresenter(savedInstanceState);
        }

        view = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = view.findViewById(R.id.assembly_recycler_view);
        assemblyAdapter = new AssemblyAdapter(presenter.getAssembies(), presenter.getListener());
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(assemblyAdapter);
        recyclerView.setLayoutManager(layoutManager);

        Button button = view.findViewById(R.id.button_add_assembly);
        button.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            intent.putExtra(Constants.REQUEST_NAME, Constants.REQUEST_INTEL);
            startActivity(intent);
        });

        return view;
    }
}
