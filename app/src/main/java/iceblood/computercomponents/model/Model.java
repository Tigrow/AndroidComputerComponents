package iceblood.computercomponents.model;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Titan'ik on 12.02.2018.
 */

public interface Model {
    Single<List<SimpleProcessor>> getTwenty(int id);
}
