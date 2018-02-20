package iceblood.computercomponents.model;

import java.util.List;

import iceblood.computercomponents.model.api.ApiInterface;
import iceblood.computercomponents.model.api.ApiModule;
import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Titan'ik on 12.02.2018.
 */

public class SimpleModel implements Model{

    ApiInterface apiInterface = ApiModule.getApiInterface();

    public Observable<SimpleProcessor> GetSimpleProcessor(){
        return Observable.just(new SimpleProcessor(1,"lol,","[f[",5,8));
    }

    @Override
    public Observable<List<SimpleProcessor>> getTwenty(int id) {
        return  apiInterface.getTwenty(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
           //     .flatMap(simpleProcessors -> Observable.fromArray(simpleProcessors));
    }
}
