package iceblood.computercomponents.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import iceblood.computercomponents.presenters.PresenterManager;
import iceblood.computercomponents.presenters.base.BasePresenter;
import iceblood.computercomponents.presenters.base.Presenter;

/**
 * Created by Titan'ik on 11.02.2018.
 */

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{
    protected T presenter;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        PresenterManager.getInstance().savePresenter(presenter, outState);
    }
    @Override
    protected void onPause() {
        super.onPause();

        presenter.detachView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
    }

}
