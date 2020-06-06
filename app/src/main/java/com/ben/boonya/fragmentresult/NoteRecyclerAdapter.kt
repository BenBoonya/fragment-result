package com.ben.boonya.fragmentresult

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ben.boonya.fragmentresult.databinding.ViewholderNoteBinding

class NoteRecyclerAdapter : RecyclerView.Adapter<NoteViewHolder>() {

    var data: ArrayList<String> = ArrayList()

    fun addItem(note: String) {
        data.add(note)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NoteViewHolder(
            ViewholderNoteBinding.inflate(
                layoutInflater,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(data[position])
    }
}