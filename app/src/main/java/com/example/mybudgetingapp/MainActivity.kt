package com.example.mybudgetingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mybudgetingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val userModel = UserModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoriesVM: CategoriesViewModel

    fun changeFragment(container: String, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (container) {
            "main" -> {
                fragmentTransaction
                    .replace(R.id.frag_main, fragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init Mock Data
        userModel.setUserBudget(UserBudget("Guest Budget"))

        //init Categories View Model
        categoriesVM = ViewModelProvider(this)[CategoriesViewModel::class.java]
        categoriesVM.setUserModel(userModel)

        //init MainActivity Views
        binding.tvBdgtUnassigned.text = "$ ${categoriesVM.getUnassignedMoney()}"

        // Date Buttons
        binding.btnSwitchDate.setOnClickListener {
            if (binding.cnstDateButtons.visibility == View.GONE) {
                binding.cnstDateButtons.visibility = View.VISIBLE
                binding.tvDateBtnWhiteSpace.visibility = View.VISIBLE
            }
            else {
                binding.cnstDateButtons.visibility = View.GONE
                binding.tvDateBtnWhiteSpace.visibility = View.GONE
            }
        }
        binding.tvDateBtnWhiteSpace.setOnClickListener {
            binding.cnstDateButtons.visibility = View.GONE
            binding.tvDateBtnWhiteSpace.visibility = View.GONE
        }


        binding.btnEditCategories.setOnClickListener {
            binding.fragMain.visibility = View.VISIBLE
            changeFragment("main", EditCategoriesFragment())
        }

    }
}