package com.example.firebase_rt_nate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var name_reg:EditText
    lateinit var mail_reg:EditText
    lateinit var pass_reg:EditText
    lateinit var createAcc_btn:Button

    //initialize firebase
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name_reg = findViewById(R.id.edtFullName)
        mail_reg = findViewById(R.id.edtEmailReg)
        pass_reg = findViewById(R.id.edtPassReg)
        createAcc_btn = findViewById(R.id.btnCreateAcc)

        auth = FirebaseAuth.getInstance()


        createAcc_btn.setOnClickListener {
            var email = mail_reg.text.toString().trim()
            var name = name_reg.text.toString().trim()
            var password = pass_reg.text.toString().trim()

            //validate user info
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Cannot Submit Empty Fields", Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()

                        //navigate back to login
                        var gotologin = Intent(this, Login_Activity::class.java)
                        startActivity(gotologin)
                    }else{
                        Toast.makeText(this, "Failed To Create Account", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}


//https://justpaste.it/cikxl