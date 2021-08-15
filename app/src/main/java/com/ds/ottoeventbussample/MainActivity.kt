package com.ds.ottoeventbussample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ds.ottoeventbussample.databinding.ActivityMainBinding
import com.squareup.otto.Subscribe

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    var bus:MainThreadBus?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)
        bus=AppController.getInstanse()?.getMainThreadBus()
        bus?.register(this)

        binding?.mainText?.setOnClickListener {
            startActivity(Intent(this, SecondaryActivity::class.java))
        }
    }

    @Subscribe
    fun getDataFromBus(received: String) {
        binding?.mainText?.text = received
        Toast.makeText(this,"Hit",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        bus?.unregister(this)
    }
}