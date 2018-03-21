package iceblood.computercomponents.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import iceblood.computercomponents.PresenterManager;

/**
 * It's Base Fragment
 */

public class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    protected T presenter;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(presenter, outState);
    }

    @Override
    public void onPause() {
        super.onPause();

        presenter.detachView();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
    }
}
