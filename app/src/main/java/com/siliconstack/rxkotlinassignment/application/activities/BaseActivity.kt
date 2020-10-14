package com.siliconstack.rxkotlinassignment.application.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment1.ui.home.HomeFragment
import com.siliconstack.rxkotlinassignment.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createLauncherFragment()
    }


    private fun createLauncherFragment() {


        supportFragmentManager
            .beginTransaction()
            .add(R.id.baseActivity_baseContainer, HomeFragment())
            .commit()

    }
}
