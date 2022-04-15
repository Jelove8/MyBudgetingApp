package com.example.mybudgetingapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoriesViewModel : ViewModel() {

    private lateinit var userModel: UserModel
    fun setUserModel(model: UserModel) {
        userModel = model
    }

    fun getUnassignedMoney(): Double {
        return userModel.getUnassignedMoney()
    }


}