package iceblood.computercomponents.model;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Model interface
 */

public interface Model {
    Single<List<SimpleProcessor>> getTwenty(int number,int product);
    Single<List<SimpleProcessor>> getTwenty(int number,int product,String name);
    Completable setLikedData(SimpleProcessor simpleProcessor);
}
