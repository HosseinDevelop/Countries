package com.hd.countries.utils

import android.util.Log

fun String.log(tag: String = "LOG_TAG") {
    Log.i(tag, this)
}