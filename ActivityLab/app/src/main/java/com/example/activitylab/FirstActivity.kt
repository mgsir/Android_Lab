package com.example.activitylab

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        bnt1.setOnClickListener{
            Toast.makeText(this,"You clicked Button 1",Toast.LENGTH_SHORT).show()
        }


        bnt2.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        bnt3.setOnClickListener{
            val intent = Intent("com.example.activitylab.ACTION_START")
            startActivity(intent)
        }

        bnt4.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }
        bnt5.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https:www.baidu.com")
            startActivity(intent)
        }

        bnt6.setOnClickListener{
            val data = "Hello SecondActivity"
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("extra_data",data)
            startActivity(intent)
        }

        bnt7.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            startActivityForResult(intent,1)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1-> if(resultCode == RESULT_OK){
                val returnedData = data?.getStringExtra("data_return")
                Toast.makeText(this,"return data is $returnedData",Toast.LENGTH_SHORT).show()
                Log.d("FirstActivity","return data is $returnedData")
            }
        }
    }
}