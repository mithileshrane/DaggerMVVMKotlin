package com.example.daggermvvmkotlin.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.daggermvvmkotlin.utils.Contants.MobileData
import com.example.daggermvvmkotlin.utils.Contants.WifiData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnectivityReceiver : LiveData<ConnectionModel>() {
    private lateinit var context: Context


    @Inject
    fun ConnectivityReceiver(context: Context) {
        this.context = context
    }


    override fun onActive() {
        super.onActive()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        context.registerReceiver(networkReceiver, filter)
    }

    override fun onInactive() {
        super.onInactive()
        context.unregisterReceiver(networkReceiver)
    }

    private val networkReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, intent: Intent?) {
            try {
                if (intent?.getExtras() != null) {
                    val activeNetwork =
                        intent.getExtras()!!.get(ConnectivityManager.EXTRA_NETWORK_INFO) as NetworkInfo
                    val isConnected =
                        activeNetwork != null && activeNetwork.isConnectedOrConnecting

                    if (isConnected) {
                        when (activeNetwork.type) {
                            ConnectivityManager.TYPE_WIFI -> postValue(
                                ConnectionModel(
                                    WifiData,
                                    true
                                )
                            )
                            ConnectivityManager.TYPE_MOBILE -> postValue(
                                ConnectionModel(
                                    MobileData,
                                    true
                                )
                            )
                        }
                    } else {
                        postValue(ConnectionModel(0, false))
                    }
                }

            } catch (e: Exception) {
                Log.e("Catched Error!", "Not able to connect to Internet!")
            }

        }
    }
}