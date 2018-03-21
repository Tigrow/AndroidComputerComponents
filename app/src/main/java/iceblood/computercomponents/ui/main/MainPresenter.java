package iceblood.computercomponents.ui.main;

import iceblood.computercomponents.ui.base.BasePresenter;

/**
 * MainPresenter for MainActivity
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
