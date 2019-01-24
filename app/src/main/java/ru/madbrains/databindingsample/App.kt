package ru.madbrains.databindingsample

import android.app.Application
import ru.madbrains.databindingsample.data.db.AppDatabase

class App : Application() {

    companion object {
        lateinit var instance: App
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = AppDatabase.get(this)
    }

}