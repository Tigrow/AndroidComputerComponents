package iceblood.computercomponents.model;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Single;

/**
 * Model interface
 */

public interface Model {
    Single<List<SimpleProcessor>> getTwenty(int id,int productID);
    Single<List<SimpleProcessor>> getTwenty(int id,int productID,String name);
    void setLikedData(SimpleProcessor simpleProcessor);
    void setUnLikedData(SimpleProcessor simpleProcessor);
}
