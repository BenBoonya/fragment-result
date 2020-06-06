package com.ben.boonya.fragmentresult

import androidx.recyclerview.widget.RecyclerView
import com.ben.boonya.fragmentresult.databinding.ViewholderNoteBinding

class NoteViewHolder(
    private val binding: ViewholderNoteBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(note: String) {
        binding.note = note
    }
}