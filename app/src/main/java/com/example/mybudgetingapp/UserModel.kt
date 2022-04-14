package com.example.mybudgetingapp

class UserModel {

    private lateinit var currentUserBudget: UserBudget

    fun getUserBudget(): UserBudget {
        return currentUserBudget
    }
    fun setUserBudget(newUserBudget: UserBudget) {
        currentUserBudget = newUserBudget
    }

    fun getUnassignedMoney(): Double {
        return currentUserBudget.bdgtUnassignedMoney
    }
}