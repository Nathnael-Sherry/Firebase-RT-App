package com.example.firebase_rt_nate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var carmake_edt:EditText
    lateinit var carmodel_edt:EditText
    lateinit var carprice_edt:EditText

    lateinit var car_view:Button
    lateinit var upload_car_photo:Button
    lateinit var upload_car_data:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carmake_edt = findViewById(R.id.edtcarmake)
        carmodel_edt = findViewById(R.id.edt_carmodel)
        carprice_edt = findViewById(R.id.edt_carprice)

        car_view = findViewById(R.id.btn_view_cars)
        upload_car_photo = findViewById(R.id.btn_carphoto)
        upload_car_data = findViewById(R.id.btn_car_data)


        var database = FirebaseDatabase.getInstance()







        //viewing uloaded data
        car_view.setOnClickListener {
            var view_cars = Intent(this, ViewCars::class.java)
            startActivity(view_cars)

        }



        //uploading all data
        upload_car_data.setOnClickListener {

            var carmake = carmake_edt.text.toString().trim()
            var carprice = carprice_edt.text.toString().trim()
            var carmodel = carmodel_edt.text.toString().trim()

            var id = System.currentTimeMillis().toString()

            var databaseRef = database.getReference("cars/"+id)

            if (carmake.isEmpty() || carprice.isEmpty() || carmodel.isEmpty()){
                Toast.makeText(this, "cannot submit empty fields", Toast.LENGTH_SHORT).show()
            }else{

                //try to upload data to firebase
                var usercar = Cars(carmake, carmodel, carprice, id)

                //creata a reference to the firebase cloud
                var ref = FirebaseDatabase.getInstance().getReference().child("cars")

                ref.setValue(usercar).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "Car Data Uploaded Successfully", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Failed to save car info", Toast.LENGTH_SHORT).show()
                    }
                }


            }

        }



        //uploading photo
        upload_car_photo.setOnClickListener {

        }
   }
}

//https://justpaste.it/bczmq