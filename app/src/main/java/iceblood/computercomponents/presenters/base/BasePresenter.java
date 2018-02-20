package iceblood.computercomponents.presenters.base;

import iceblood.computercomponents.view.base.BaseView;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Titan'ik on 09.02.2018.
 */

public abstract class BasePresenter<T extends BaseView> implements Presenter<T> {

    private T mMvpView;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
        updateView();
    }

    public abstract void updateView();

    @Override
    public void detachView() {
        mMvpView = null;
        compositeDisposable.clear();
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(BaseView) before" +
                    " requesting data to the Presenter");
        }
    }
}
