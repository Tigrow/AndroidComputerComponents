package iceblood.computercomponents.model.api;

import java.util.List;

import iceblood.computercomponents.model.objects.SimpleProcessor;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * ApiInterface
 */

public interface ApiInterface {
    @GET("api/gettwenty")
    Single<List<SimpleProcessor>> getTwenty(@Query("number") int number);

    @GET("api/gettwenty")
    Single<List<SimpleProcessor>> getTwenty(@Query("number") int number,@Query("name") String name);
}
