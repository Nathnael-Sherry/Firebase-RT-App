package com.example.firebase_rt_nate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var data_entry:EditText
    lateinit var save_button:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data_entry = findViewById(R.id.edtdata)
        save_button = findViewById(R.id.btnSave)

        var database = FirebaseDatabase.getInstance()
        var databaseRef = database.reference

        save_button.setOnClickListener {
            var user_data = data_entry.text.toString().trim()

            databaseRef.setValue(user_data)

//            Toast.makeText(this, user_data, Toast.LENGTH_SHORT).show()
        }

    }
}