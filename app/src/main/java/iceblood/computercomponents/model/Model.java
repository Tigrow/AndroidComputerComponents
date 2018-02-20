package iceblood.computercomponents.model;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Observable;

/**
 * Created by Titan'ik on 12.02.2018.
 */

public interface Model {
    Observable<List<SimpleProcessor>> getTwenty(int id);
}
