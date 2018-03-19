package iceblood.computercomponents.model;

import java.util.List;

import iceblood.computercomponents.ApplicationMVP;
import iceblood.computercomponents.model.database.Dao.SimpleProcessorDao;
import iceblood.computercomponents.model.api.ApiInterface;
import iceblood.computercomponents.model.api.ApiModule;
import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Titan'ik on 12.02.2018.
 */

public class SimpleModel implements Model {

    ApiInterface apiInterface = ApiModule.getApiInterface();
    SimpleProcessorDao simpleProcessorDao = ApplicationMVP.getInstance().getDatabase().simpleProcessorDao();

    @Override
    public Single<List<SimpleProcessor>> getTwenty(int number, int product) {
        return apiInterface.getTwenty(number)
                .flatMapObservable(simpleProcessor -> Observable.fromIterable(simpleProcessor))
                .doOnNext(simpleProcessor ->
                        simpleProcessor.setLiked(isLiked(simpleProcessor.getId())))
                .toList()
                .onErrorResumeNext(simpleProcessorDao.getAll())
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Single<List<SimpleProcessor>> getTwenty(int number, int product, String name) {
        return apiInterface.getTwenty(number, name)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Completable setLikedData(SimpleProcessor simpleProcessor) {

        return Completable.fromAction(() -> updateLikedData(simpleProcessor))
                .subscribeOn(Schedulers.io());

    }

    private boolean isLiked(int id) {
        SimpleProcessor simpleProcessor = simpleProcessorDao.getById(id);
        if (simpleProcessor != null)
            return simpleProcessor.isLiked();
        else
            return false;
    }

    private void updateLikedData(SimpleProcessor simpleProcessor) {
        if (simpleProcessorDao.getById(simpleProcessor.getId()) != null)
            simpleProcessorDao.update(simpleProcessor);
        else
            simpleProcessorDao.insert(simpleProcessor);
    }
}
