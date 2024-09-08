package io.github.katarem.utils

import android.annotation.SuppressLint
import android.content.Context
@SuppressLint("StaticFieldLeak")
object AppContext {

    private var context: Context? = null

    fun setUp(context: Context){
        this.context = context
    }

    fun get(): Context{
        return this.context!!
    }

}