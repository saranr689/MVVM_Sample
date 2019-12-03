package com.aidlexample.mvvm_sample;

import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel<MyNavigator> {

    MutableLiveData<DummyJsonModel> employeeModelMutableLiveData = new MutableLiveData<>();
    private AppRepositry appRepositry = AppRepositry.getInstance();

    public void getEmployeeList(){

        employeeModelMutableLiveData = appRepositry.getEmploye();
    }


}
