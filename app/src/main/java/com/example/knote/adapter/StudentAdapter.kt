package com.example.knote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.knote.R
import com.example.knote.database.StudentModel

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    private var stdList: ArrayList<StudentModel> =ArrayList()

    fun addItems(items: ArrayList<StudentModel>){
        this.stdList = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  StudentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_note , parent , false)
    )

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val std = stdList[position]
        holder.bindView(std)
    }

    override fun getItemCount(): Int {
        return stdList.size
    }


    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){

        private var name  = view.findViewById<TextView>(R.id.tvNameNote)
        private var email = view.findViewById<TextView>(R.id.tvDateNote)


        fun bindView(std: StudentModel){
            name.text = std.name
            email.text = std.email
        }
    }
}