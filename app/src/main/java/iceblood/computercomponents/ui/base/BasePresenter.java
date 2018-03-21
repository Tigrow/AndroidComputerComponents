package iceblood.computercomponents.ui.base;

import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;

/**
 * It is base presenter
 */

public abstract class BasePresenter<T extends BaseView> implements Presenter<T> {

    private T mMvpView;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
        updateView();
        Log.d("LOL", "attachView");
    }

    public abstract void updateView();

    @Override
    public void detachView() {
        mMvpView = null;
        compositeDisposable.clear();
        Log.d("LOL", "detachView");
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
         MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(BaseView) before" +
                    " requesting data to the Presenter");
        }
    }
}
