package com.aidlexample.mvvm_sample;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepositry {

    private static AppRepositry appRepositry;
    private  ApiInterFace apiInterFace;


    static AppRepositry getInstance(){
        if (appRepositry == null){
            appRepositry = new AppRepositry();
        }
        return appRepositry;
    }

    private AppRepositry(){
        apiInterFace = BaseRepositry.cteateService(ApiInterFace.class);
    }

    public MutableLiveData<DummyJsonModel> getEmploye(){
        MutableLiveData<DummyJsonModel> employeeResposeData = new MutableLiveData<>();

        apiInterFace.getEmployeeApiResponse().enqueue(new Callback<DummyJsonModel>() {
            @Override
            public void onResponse(Call<DummyJsonModel> call, Response<DummyJsonModel> response) {

                if (response.isSuccessful())
                {
                    employeeResposeData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<DummyJsonModel> call, Throwable t) {

                Log.d("_D_FAILURE", "onFailure: "+t.getMessage());
                employeeResposeData.setValue(null);
            }
        });

        return employeeResposeData;
    }
}
