package com.luis.marketapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    lateinit var btnNewUser: MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        btnNewUser = findViewById(R.id.btnNewUser)

        btnNewUser.setOnClickListener {
            intent = Intent(this,newuserActivity::class.java)
            startActivity(intent!!)
        }
    }
}