package com.xthread

import android.content.Context
import android.util.Log
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText

fun print(e: Exception){
    Log.e("",e.stackTraceToString())
}

fun showMessage(
    context: Context,
    message: String?
) = makeText(context, message, LENGTH_LONG).show()