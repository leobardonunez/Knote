package com.example.knote

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.knote.adapter.NoteAdapter
import com.example.knote.adapter.StudentAdapter
import com.example.knote.database.StudentModel
import com.example.knote.database.SQLiteHelper
import com.example.knote.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var sqliteHelper: SQLiteHelper
    private var adapter: StudentAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar recyclerview
        initRecyclerView()

        //Mostrar datos de base de datos en Recyclerview

        fun getStudents(){
            val stdList = sqliteHelper.getAllStudent()
            Log.e("pppp", "${stdList.size}")

            adapter?.addItems(stdList)
        }
        binding.showbutton.setOnClickListener{
            getStudents()
            Toast.makeText(this , "Los registros deberian mostrarse" , Toast.LENGTH_SHORT).show()
        }
        //Mostrar datos de base de datos en Recyclerview

        ////Añadir a base de datos
        binding.modalButton.setOnClickListener{
            val bottomSheetDialog = BottomSheetDialog(
                this@MainActivity, R.style.BottomSheetDialogTheme
            )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.layout_bottom_sheet,
                findViewById<LinearLayout>(R.id.bottomSheet)
            )

            sqliteHelper = SQLiteHelper(this)

            //Boton guardar
            bottomSheetView.findViewById<View>(R.id.btn_save_note).setOnClickListener {
                Toast.makeText(this@MainActivity, "Share...", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()

                //Nombre de la nota
                val valor1 = bottomSheetView.findViewById<EditText>(R.id.camponombre).text
                //Subtareas
                val subtarea = bottomSheetDialog.findViewById<CheckBox>(R.id.laybottom_checkBox)?.text
                //Notas
                val nota = bottomSheetDialog.findViewById<EditText>(R.id.laybottom_nota)?.text

                if (valor1.isEmpty()){
                    Toast.makeText(this , "Porfavor introduzca los datos requeridos" , Toast.LENGTH_SHORT).show()
                }else{
                    val std = StudentModel( name = valor1.toString() , email = nota.toString())
                    val status = sqliteHelper.insertStudent(std)

                    //saber si se inserto o no
                    if (status > -1){
                        Toast.makeText(this , "Student add" , Toast.LENGTH_SHORT).show()
                        println("LOS CAMPOS AÑADIDOS SON: " + std)
                        println("EL REGISTRO SE AÑADIO CON EXITO!!!")
                        vibrate_phone()
                    }else{
                        Toast.makeText(this, "Not added" , Toast.LENGTH_SHORT).show()
                    }
                }
            }
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }
        ////Añadir a base de datos



        //modal
       /* val listaNotas = mutableListOf<Note>()
        val adapter =  NoteAdapter(listaNotas)
        recyclerViewNote.adapter = adapter
        binding.modalButton.setOnClickListener{

            val bottomSheetDialog = BottomSheetDialog(
                this@MainActivity, R.style.BottomSheetDialogTheme
            )
            val bottomSheetView = LayoutInflater.from(applicationContext).inflate(
                R.layout.layout_bottom_sheet,
                findViewById<LinearLayout>(R.id.bottomSheet)
            )

            //Fecha del sistema
            bottomSheetDialog.findViewById<TextView>(R.id.laybottom_fecha)
            val fecha = bottomSheetDialog.findViewById<TextView>(R.id.laybottom_fecha)
            val calendar: Calendar = Calendar.getInstance()
            val simpleDateFormat = SimpleDateFormat("dd MMM yyyy")
            val dateTime = simpleDateFormat.format(calendar.time)
            fecha?.setText(dateTime)

            //Boton guardar
            bottomSheetView.findViewById<View>(R.id.btn_save_note).setOnClickListener {
                Toast.makeText(this@MainActivity, "Share...", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()

                //Nombre de la nota
                val valor1 = bottomSheetView.findViewById<EditText>(R.id.camponombre).text
                //Subtareas
                val subtarea =
                    bottomSheetDialog.findViewById<CheckBox>(R.id.laybottom_checkBox)?.text
                //Notas
                val nota = bottomSheetDialog.findViewById<EditText>(R.id.laybottom_nota)?.text

                //Añadir
                listaNotas.add(
                    Note(
                        valor1.toString(),
                        subtarea.toString(),
                        nota.toString(),
                        "Creado:   $dateTime"
                    )
                )
                adapter.notifyDataSetChanged()

                println("El valor es : " + adapter)
                println("El valor es : " + valor1)
                vibrate_phone()
            }
            //Boton guardar
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }*/
        //modal

    }


    fun initRecyclerView(){
        binding.recyclerViewNote.layoutManager = LinearLayoutManager(this)
        //binding.recyclerViewNote.adapter = NoteAdapter(NoteProvider.noteList )

        //Lo nuevo
        /*binding.recyclerViewNote.adapter = StudentAdapter()
        binding.recyclerViewNote.adapter = adapter*/
    }

    fun onItemSelected(note: Note){
        Toast.makeText(this , note.name , Toast.LENGTH_SHORT).show()
    }

    //Vibrar al guardar
    fun vibrate_phone(){
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE)as Vibrator
        if(vibrator.hasVibrator()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(88 ,10))
            }
            else{
                vibrator.vibrate(3)
            }
        }
    }

}