package com.bogomolov.findfilm

import android.app.Application
import com.bogomolov.findfilm.database.Database

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Database.init(this)
    }
}