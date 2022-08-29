package com.sorgeligt.gamelib.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sorgeligt.gamelib.R
import com.sorgeligt.gamelib.databinding.ActivityMainBinding
import com.sorgeligt.gamelib.ui.mainscreen.MainScreenFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, MainScreenFragment())
                .commit()
        }
    }


}