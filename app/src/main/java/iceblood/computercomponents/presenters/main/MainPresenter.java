package iceblood.computercomponents.presenters.main;

import java.util.List;

import iceblood.computercomponents.presenters.base.BasePresenter;
import iceblood.computercomponents.view.main.MainView;

/**
 * Created by Titan'ik on 09.02.2018.
 */

public class MainPresenter extends BasePresenter<MainView> implements MainMvpPresenter {


    public void Click(){
        getMvpView().showMessage();
    }

    @Override
    public void updateView() {
        //
    }
}
