package iceblood.computercomponents.presenters;

import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * Created by Titan'ik on 08.02.2018.
 */

public abstract class BasePresenter<M,V> {
    protected M model;
    private WeakReference<V> view;

    public void setModel(M model){
        //resetState();
        this.model = model;
        if(setupDone()){
            updateView();
        }
    }

    public void bindView(@NonNull V view){
        this.view = new WeakReference<>(view);
        if(setupDone()){
            updateView();
        }
    }
    public void unbindView(){
        this.view = null;
    }

    protected V view(){
        if(view == null){
            return null;
        }else {
            return view.get();
        }
    }

    protected abstract void updateView();

    protected boolean setupDone(){
        return view() !=null && model !=null;
    }
}
