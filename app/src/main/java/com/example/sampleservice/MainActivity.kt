package com.example.sampleservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.btn_start)
        val btnStop: Button = findViewById(R.id.btn_stop)
        val textService: TextView = findViewById(R.id.text_service)


        val inputData: EditText = findViewById(R.id.data_service)
        val btnData: Button = findViewById(R.id.send_data)

//        btnStart.setOnClickListener {
//            Intent(this, MyIntentService::class.java).also {
//                startService(it)
//                textService.text = "Service is Running"
//            }
//        }
//
//        btnStop.setOnClickListener {
//            MyIntentService.stopService()
//            textService.text = "Service is Stopped"
//        }

        btnStart.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                textService.text = "Service is Running (*_*)"
            }
        }

        btnStop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                textService.text = "Service is Stopped (>_<)"
            }
        }

        btnData.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = inputData.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }
    }
}