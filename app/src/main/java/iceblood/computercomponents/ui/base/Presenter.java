package iceblood.computercomponents.ui.base;

/**
 * Base presenter interface
 */

public interface Presenter<V extends BaseView> {

    void attachView(V mvpView);

    void detachView();
}