package iceblood.computercomponents.model.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiModule for load apiInterface
 */

public class ApiModule {
    public static ApiInterface getApiInterface() {
        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl("http://192.168.1.61:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        return builder.build().create(ApiInterface.class);
    }
}
