package com.example.knote.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.knote.NotaActivity
import com.example.knote.Note
import com.example.knote.R
import com.example.knote.database.StudentModel
import kotlinx.android.synthetic.main.activity_main.*

class NoteAdapter(private val noteList: List<Note>) : RecyclerView.Adapter<NoteViewHolder> (){

    //Pasamos el layout que podra modificar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        //Un context desde fuera de un MainActivity se saca desde cualquier vista
        val layoutInflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(layoutInflater.inflate(R.layout.item_note, parent , false))
    }

    //Pasa por cada item y llama a render ->NoteViewHolder pasandole el item
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = noteList[position]
        holder.render(item)


        ///////
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context , "Esta es la tarea " + item.name , Toast.LENGTH_SHORT).show()
            val intent = Intent(holder.itemView.context , NotaActivity::class.java)
            intent.putExtra("note" , item)
            holder.itemView.context.startActivity(intent)
            println("Esto contiene el item : " + noteList[position])
        }
        ////////
    }

    //Hay que devolver el tamaño de la lista de los que se van a mostrar
    override fun getItemCount(): Int {
        return noteList.size
    }
}