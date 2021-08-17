package com.bogomolov.findfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bogomolov.findfilm.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, MainFragment())
                .commit()
    }
}