package iceblood.computercomponents.view.assembly;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import iceblood.computercomponents.R;
import iceblood.computercomponents.model.Constants;
import iceblood.computercomponents.presenters.PresenterManager;
import iceblood.computercomponents.presenters.assembly.AssemblyPresenter;
import iceblood.computercomponents.view.base.BaseFragment;
import iceblood.computercomponents.view.search.SearchActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment<AssemblyPresenter> implements AssemblyView {

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

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = view.findViewById(R.id.button_add_assembly);
        button.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            intent.putExtra(Constants.REQUEST_NAME, Constants.REQUEST_INTEL);
            startActivity(intent);
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
