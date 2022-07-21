package com.thioponiman.recycleview12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        /* Handler().postDelayed(Runnable {

        startActivity(intent(this,Mainactivity::class.java))
        },3000*/

        Handler(Looper.getMainlooper()).postDelayed({
            startActivity(intent( this,MainActivity::class.java))
            finish()
        }, 3000)
    }
}