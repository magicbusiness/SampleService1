package com.example.sampleservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service()
{
    init
    {
        Log.d(TAG, "Service is Running...")
    }

    companion object
    {
        const val TAG = "MY_SERVICE"
    }

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        val dataString = intent?.getStringExtra("EXTRA_DATA")

        dataString?.let {
            Log.d(TAG, dataString)
        }

        // If want complex service and not run in main thread
        Thread{
            while (true){

            }
        }.start()

        // If Service was terminated
        return START_STICKY  // If Android terminated service then it will recreate again
//        return START_NOT_STICKY  // If Android terminated service then it wont recreate again
//        return START_REDELIVER_INTENT // redeliver last intent pass to service class
    }

    // To terminate service in Service
    override fun onDestroy()
    {
        super.onDestroy()

        Log.d(TAG, "Service has been Terminated...")
    }
}