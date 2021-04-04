package com.example.sampleservice

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.

 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.

 */
class MyIntentService : IntentService("MyIntentService")
{
    init
    {
        instance = this
    }

    companion object
    {
        // for passing data
        private lateinit var instance: MyIntentService

        //
        var isRunning = false

        //
        fun stopService()
        {
            Log.d("MyIntentService", "Service is Stopping...")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?)
    {
        isRunning = true

        try {
            while (isRunning)
            {
                Log.d("MyIntentService", "Service is Running...")

                // Delay
                Thread.sleep(1000)
            }
        }

        catch (e: InterruptedException)
        {
            Thread.currentThread().interrupt()
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String)
    {
        TODO("Handle action Foo")
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionBaz(param1: String, param2: String)
    {
        TODO("Handle action Baz")
    }
}