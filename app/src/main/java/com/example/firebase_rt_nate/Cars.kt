package com.example.firebase_rt_nate

class Cars {
    var carmake: String? = null
    var carmodel: String? = null
    var carprice: String? = null
    var car_id: String? = null

    constructor(carmake: String, carmodel: String, carprice: String, car_id: String) {
        this.carmake = carmake
        this.carprice =carprice
        this.carmodel = carmodel
        this.car_id = car_id

    }
    constructor()
}

//https://justpaste.it/cf65y