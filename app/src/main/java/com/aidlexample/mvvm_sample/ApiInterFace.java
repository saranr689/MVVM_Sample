package com.aidlexample.mvvm_sample;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiInterFace {

    @GET("/todos/1")
    Call<DummyJsonModel> getEmployeeApiResponse();
}
