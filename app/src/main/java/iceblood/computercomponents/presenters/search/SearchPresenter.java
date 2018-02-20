package iceblood.computercomponents.presenters.search;

import java.util.ArrayList;
import java.util.List;

import iceblood.computercomponents.model.SimpleModel;
import iceblood.computercomponents.model.objects.SimpleProcessor;
import iceblood.computercomponents.presenters.base.BasePresenter;
import iceblood.computercomponents.view.search.SearchView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Titan'ik on 09.02.2018.
 */

public class SearchPresenter extends BasePresenter<SearchView>implements SearchMvpPresenter{



    private List<SimpleProcessor> simpleProcessorsP;
    private SimpleModel simpleModel;
    private int number = 1;

    public SearchPresenter(){
        simpleProcessorsP = new ArrayList<>();
        simpleModel = new SimpleModel();

    }

    @Override
    public void updateView() {
        if(simpleProcessorsP.isEmpty()){
            loadData();
        }else
        {
            getMvpView().showRecyclerViewData();
        }
    }

    public void loadData(){
        getMvpView().setVisibleProgressBar(true);

        simpleModel.getTwenty(number).subscribe(new Observer<List<SimpleProcessor>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<SimpleProcessor> simpleProcessors) {
                simpleProcessorsP.addAll(simpleProcessors);
                if(isViewAttached()) {
                    getMvpView().showRecyclerViewData();
                    getMvpView().setVisibleProgressBar(false);
                }

            }

            @Override
            public void onError(Throwable e) {
                if(isViewAttached()) {
                    getMvpView().showError();
                    getMvpView().setVisibleProgressBar(false);
                }
            }

            @Override
            public void onComplete() {
                //simpleProcessorsP.add(new SimpleProcessor(10, "Complited", "", 8, 3));

            }
        });
        number++;
    }
    public void addData(){
        //simpleProcessors.add(new SimpleProcessor(10,"lol","azaz",8,3));


        /*SM.GetSimpleProcessor().subscribe(new Observer<SimpleProcessor>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(SimpleProcessor simpleProcessor) {
                simpleProcessors.add(simpleProcessor);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/
        //SM.GetSimpleProcessor().subscribe(simpleProcessor->simpleProcessors.add(simpleProcessor));


    }
    @Override
    public List<SimpleProcessor> getSimpleProcessors() {
        return simpleProcessorsP;
    }
}
