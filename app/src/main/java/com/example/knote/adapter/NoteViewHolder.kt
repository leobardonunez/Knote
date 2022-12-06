package com.example.knote.adapter

import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.knote.*
import com.example.knote.databinding.ItemNoteBinding

class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val binding = ItemNoteBinding.bind(view)


    fun render(noteModel: Note){
         binding.tvNameNote.text = noteModel.name
         binding.tvDateNote.text = noteModel.fecha
         binding.tvSubtarea.text = noteModel.subtarea
         //date.text = noteModel.date


        //Control de clicks a item
        itemView.setOnClickListener{
            //onClickListener(noteModel)
            Toast.makeText(binding.tvNameNote.context , noteModel.name ,
                Toast.LENGTH_SHORT).show()
        }
    }
}