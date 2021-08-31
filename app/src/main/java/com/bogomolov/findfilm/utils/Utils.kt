package com.bogomolov.findfilm.utils

import android.util.Log
import androidx.viewbinding.BuildConfig

fun loggingDebug(string: String) {
    if (BuildConfig.DEBUG)
        Log.d("loggingDebug", string)
}