package com.example.knote

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.*
import com.example.knote.adapter.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nota.*
import java.text.SimpleDateFormat
import java.util.*

class NotaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        //Mostrado de datos
        val note = intent.getSerializableExtra("note") as Note

        nombre_nota.text = note.name
        acnota_fechaActual.text = note.fecha
        acnota_checkbox.text = note.subtarea
        acnota_nota.setText(note.nota)
       //Mostrado de datos


        val objvibrar: MainActivity = MainActivity()
        val btn_update = findViewById<Button>(R.id.acnota_save)
        btn_update.setOnClickListener {
           Toast.makeText(this , "Boton actualizar" , Toast.LENGTH_SHORT).show()
            //objvibrar.vibrate_phone()
        }
    }
}


