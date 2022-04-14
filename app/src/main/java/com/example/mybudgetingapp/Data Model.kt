package com.example.mybudgetingapp

import java.util.*

data class UserBudget(
    var bdgtName: String,
    var bdgtUnassignedMoney: Double = 0.00,
    var bdgtAllAccounts: MutableList<Account> = mutableListOf(),
    var bdgtAllTransactions: MutableList<Transaction> = mutableListOf(),
    var bdgtAllDistributions: MutableList<Distribution> = mutableListOf()
)

data class Distribution(
    val bdgtYear: Int = Calendar.getInstance().get(Calendar.YEAR),
    val bdgtMonth: Int = Calendar.getInstance().get(Calendar.MONTH), // 0 = January ... 11 = December
    val bdgtCategories: MutableList<Category> = mutableListOf()
)

data class Account(
    var accNickname: String,
    val acctType: String,
    val acctBalance: Double = 0.00,
    val acctTransactionIDs: MutableList<String> = mutableListOf()
)

data class Category(
    var catName: String,
    val catID: String,
    val catType: Boolean = true,  // True = category, False = subcategory
    val catAssignedMoney: Double = 0.00,
    val catAvailableMoney: Double = 0.00,
    val subcategories: MutableList<Category> = mutableListOf()
)

data class Transaction(
    val id: String,
    var amount: Double = 0.00,
    var payee: String? = null,
    var subcategoryID: String? = null,
    var cleared: Boolean = false,
    var memo: String? = null
)
