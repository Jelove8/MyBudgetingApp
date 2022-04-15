package com.example.mybudgetingapp

data class UserBudget(
    var bdgtName: String,
    var bdgtUnassignedMoney: Double = 0.00,
    var bdgtAllAccounts: MutableList<Accounts> = mutableListOf(),
    var allMonthlyMonthlyDistributions: MutableList<MonthlyDistribution> = mutableListOf(),
    var bdgtAllTransactions: MutableList<Transactions> = mutableListOf(),
    var bdgtAllCategories: MutableList<Category> = mutableListOf(),
)

data class MonthlyDistribution(
    val bdgtYear: Int,
    val bdgtMonth: Int, // 0 = January ... 11 = December
    val bdgtCategories: MutableList<Category> = mutableListOf()
)

data class Accounts(
    var acctName: String,
    var acctType: String,
    var acctBalance: Double = 0.00,
    var acctTransactionIDs: MutableList<String> = mutableListOf()
)

data class Category(
    var catName: String?,
    var catType: Boolean = true,  // True = category, False = subcategory
    var catAssignedMoney: Double = 0.00,
    var catAvailableMoney: Double = 0.00,
    var subcategories: MutableList<Category> = mutableListOf()
)

data class Transactions(
    var id: String,
    var amount: Double = 0.00,
    var payee: String? = null,
    var subcategory: String? = null,
    var cleared: Boolean = false,
    var memo: String? = null
)
