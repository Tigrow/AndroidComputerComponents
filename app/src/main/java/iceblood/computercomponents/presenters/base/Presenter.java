package iceblood.computercomponents.presenters.base;

import iceblood.computercomponents.view.base.BaseView;

/**
 * Created by Titan'ik on 09.02.2018.
 */

public interface Presenter<V extends BaseView> {

    void attachView(V mvpView);

    void detachView();
}