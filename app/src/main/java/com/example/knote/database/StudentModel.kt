package com.example.knote.database

import kotlin.random.Random

data class StudentModel (
    var id: Int = getAutoId(),
    var name: String = "",
    var email: String = ""
){
    companion object{
        fun getAutoId():Int{
            //Random() en el video es Random()->java.util
            val random = Random
            return random.nextInt(100)
        }
    }
}