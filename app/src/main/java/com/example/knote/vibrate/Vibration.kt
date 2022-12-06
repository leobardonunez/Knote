package com.example.knote.vibrate

import android.app.Application
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService





class Vibration(){
    /*fun vibrate_phone(){
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        //val vibrator = this@MainActivity(Context.VIBRATOR_SERVICE) as Vibrator?

        //val vibrator = getSystemServicefuncion("a")
        if (vibrator.hasVibrator()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(88, 10))
            } else {
                vibrator.vibrate(3)
            }
         }
    }*/

    fun Vibration(){
        //Toast.makeText(this, "El telefono esta vibrando" , Toast.LENGTH_SHORT).show()
        println("El telefono esta vibrando")
    }

    /*private fun getSystemService(vibratorService: String): Any {
           return getSystemService(Context.VIBRATOR_SERVICE)as Vibrator
    }*/
}
