package iceblood.computercomponents.model.api;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Titan'ik on 12.02.2018.
 */

public interface ApiInterface {
    @GET("api/gettwenty")
    Single<List<SimpleProcessor>> getTwenty(@Query("number") int number);
}
