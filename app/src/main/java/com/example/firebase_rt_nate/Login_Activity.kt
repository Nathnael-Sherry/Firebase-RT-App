package com.example.firebase_rt_nate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login_Activity : AppCompatActivity() {
    lateinit var mail_lgn:EditText
    lateinit var pass_lgn:EditText
    lateinit var loginButton_lgn:Button
    lateinit var registerButton_lgn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mail_lgn = findViewById(R.id.edtEmaillgn)
        pass_lgn = findViewById(R.id.edtPasslgn)
        loginButton_lgn = findViewById(R.id.btnLoginlgn)
        registerButton_lgn = findViewById(R.id.btnRegisterlgn)

        loginButton_lgn.setOnClickListener {
            //-+
        }

        registerButton_lgn.setOnClickListener {
            //navigate user to the registration page
            var gotoregister = Intent(this, RegisterActivity::class.java)
            startActivity(gotoregister)

        }

    }
}