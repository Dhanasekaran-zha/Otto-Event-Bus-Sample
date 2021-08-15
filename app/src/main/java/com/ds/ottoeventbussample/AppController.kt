package com.ds.ottoeventbussample

import android.app.Application

class AppController:Application() {

    companion object {
        var appController: AppController? = null

        fun getInstanse(): AppController? {
            return appController
        }
    }

    private var mainThreadBus:MainThreadBus?=null


    override fun onCreate() {
        super.onCreate()
        appController=this
        mainThreadBus= MainThreadBus()
    }

    fun getMainThreadBus():MainThreadBus{
        if (mainThreadBus != null){
            return mainThreadBus!!
        }else{
            mainThreadBus= MainThreadBus()
            return mainThreadBus!!
        }
    }
}