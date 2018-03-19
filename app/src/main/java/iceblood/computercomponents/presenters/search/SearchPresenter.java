package iceblood.computercomponents.presenters.search;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import iceblood.computercomponents.model.Constants;
import iceblood.computercomponents.model.Model;
import iceblood.computercomponents.model.SimpleModel;
import iceblood.computercomponents.model.objects.SimpleProcessor;
import iceblood.computercomponents.presenters.base.BasePresenter;
import iceblood.computercomponents.view.search.SearchView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by Titan'ik on 09.02.2018.
 */

public class SearchPresenter extends BasePresenter<SearchView> implements SearchMvpPresenter {

    private int productID = Constants.REQUEST_INTEL;

    private List<SimpleProcessor> simpleProcessorsP;
    private Model simpleModel;
    private int number = 0;

    public SearchPresenter() {
        Log.d("lol", "SearchPresenter: Created");
        simpleProcessorsP = new ArrayList<>();
        simpleModel = new SimpleModel();

    }

    @Override
    public void updateView() {
        if (simpleProcessorsP.isEmpty()) {
            loadData();
        } else {
            getMvpView().showRecyclerViewData();
        }
    }

    public void loadData() {
        getMvpView().setVisibleProgressBar(true);

        compositeDisposable.add(simpleModel.getTwenty(number, productID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<SimpleProcessor>>() {
                    @Override
                    public void onSuccess(List<SimpleProcessor> simpleProcessors) {
                        simpleProcessorsP.addAll(simpleProcessors);
                        if (isViewAttached()) {
                            getMvpView().showRecyclerViewData();
                            getMvpView().setVisibleProgressBar(false);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()) {
                            getMvpView().showError();
                            getMvpView().setVisibleProgressBar(false);
                        }
                    }
                }));
        number++;
    }

    public void addData() {
        //
    }

    public void LikeData(int position, boolean cheked) {
        compositeDisposable.add(simpleModel.setLikedData(simpleProcessorsP.get(position))
                .subscribe());
    }

    @Override
    public List<SimpleProcessor> getSimpleProcessors() {
        return simpleProcessorsP;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
