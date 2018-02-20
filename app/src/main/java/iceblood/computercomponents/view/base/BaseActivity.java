package iceblood.computercomponents.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import iceblood.computercomponents.presenters.base.BasePresenter;
import iceblood.computercomponents.presenters.base.Presenter;

/**
 * Created by Titan'ik on 11.02.2018.
 */

public class BaseActivity extends AppCompatActivity implements BaseView{
    protected Presenter presenter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //presenter = new BasePresenter<BaseView>();
        presenter.attachView(this);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.detachView();
    }
}
