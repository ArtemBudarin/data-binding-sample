package ru.madbrains.databindingsample.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.madbrains.databindingsample.ui.LaunchDestination.PRODUCTS_ACTIVITY
import ru.madbrains.databindingsample.ui.products.ProductsActivity

class LauncherActivity : AppCompatActivity() {

    lateinit var launcherViewModel: LauncherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        launcherViewModel = ViewModelProviders.of(this).get(LauncherViewModel::class.java)

        launcherViewModel.launchLiveData.observe(this, Observer { destination ->
            when (destination) {
                PRODUCTS_ACTIVITY -> ProductsActivity.start(this)
            }
            finish()
        })

    }
}
