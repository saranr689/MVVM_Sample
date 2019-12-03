package com.aidlexample.mvvm_sample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRepositry {


    private static Retrofit retrofit;

    private BaseRepositry() {
    }


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .build();
            return retrofit;
        } else {

            return retrofit;
        }


    }

    public static <S> S cteateService(Class<S> serviceClass) {
        return getRetrofitInstance().create(serviceClass);
    }
}
