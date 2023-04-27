package com.example.firebase_rt_nate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    lateinit var name_reg:EditText
    lateinit var mail_reg:EditText
    lateinit var pass_reg:EditText
    lateinit var createAcc_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name_reg = findViewById(R.id.edtFullName)
        mail_reg = findViewById(R.id.edtEmailReg)
        pass_reg = findViewById(R.id.edtPassReg)
        createAcc_btn = findViewById(R.id.btnCreateAcc)


        createAcc_btn.setOnClickListener {

        }

    }
}
//git config user.email "nathnaelsherry@outlook.com"