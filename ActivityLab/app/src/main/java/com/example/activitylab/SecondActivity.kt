package com.example.activitylab

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val extraData = intent.getStringExtra("extra_data")
        if(extraData != null){
            Toast.makeText(this,"extra data  is $extraData", Toast.LENGTH_SHORT).show()
            Log.d("SecondActivity","extra data is $extraData")
        }
        bnt8.setOnClickListener{
            val intent = Intent()
            intent.putExtra("data_return","Hello FirstActivity")
            setResult(RESULT_OK,intent)
            finish()
        }
    }


}