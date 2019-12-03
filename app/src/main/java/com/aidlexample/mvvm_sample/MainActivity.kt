package com.aidlexample.mvvm_sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


class MainActivity : AppCompatActivity(), MyNavigator {

    override fun makeEvent() {

    }

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.navigator = this
        mainViewModel.getEmployeeList()
        mainViewModel.employeeModelMutableLiveData.observe(this, Observer<DummyJsonModel>() {

            Log.d("_D", it.title + "");
        })

    }
}
