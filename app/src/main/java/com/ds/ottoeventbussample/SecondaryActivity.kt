package com.ds.ottoeventbussample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ds.ottoeventbussample.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {

    private var binding: ActivitySecondaryBinding? = null
    var bus:MainThreadBus?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        val view=binding?.root
        setContentView(view)
        bus=AppController.getInstanse()?.getMainThreadBus()
        bus?.register(this)

        binding?.btn?.setOnClickListener {
            if (binding?.edtText?.text!!.isNotEmpty()){
                bus?.post(binding?.edtText?.text.toString())
                finish()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bus?.unregister(this)
    }
}