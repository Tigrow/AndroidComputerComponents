package iceblood.computercomponents.model;

import java.util.List;

import iceblood.computercomponents.ApplicationMVP;
import iceblood.computercomponents.model.api.ApiInterface;
import iceblood.computercomponents.model.api.ApiModule;
import iceblood.computercomponents.model.database.DbHandler;
import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Titan'ik on 12.02.2018.
 */

public class SimpleModel implements Model{

    ApiInterface apiInterface = ApiModule.getApiInterface();
    DbHandler dbHandler = ApplicationMVP.getDbHandler();

    @Override
    public Single<List<SimpleProcessor>> getTwenty(int id,int productID) {
        return  apiInterface.getTwenty(id)
                .flatMapObservable(simpleProcessor -> Observable.fromIterable(simpleProcessor))
                .doOnNext(simpleProcessor -> simpleProcessor.setLiked(dbHandler.isSimpleDataLiked(simpleProcessor.getId())))
                .toList()
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Single<List<SimpleProcessor>> getTwenty(int id, int productID, String name) {
        return apiInterface.getTwenty(id,name)
                .subscribeOn(Schedulers.io());
    }


    @Override
    public void setLikedData(SimpleProcessor simpleProcessor) {
        dbHandler.addSimpleData(simpleProcessor);
    }
    @Override
    public void setUnLikedData(SimpleProcessor simpleProcessor) {
        dbHandler.delete(simpleProcessor.getId());
    }
}
