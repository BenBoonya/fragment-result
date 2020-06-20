package com.ben.boonya.fragmentresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ben.boonya.fragmentresult.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment() {

    private lateinit var binding: FragmentNoteListBinding

    private val adapter: NoteRecyclerAdapter by lazy { NoteRecyclerAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListBinding.inflate(layoutInflater)
        binding.adapter = adapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>(
            ADD_NOTE
        )?.observe(viewLifecycleOwner, Observer { note ->
            adapter.addItem(note)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addNoteFab.setOnClickListener {
            navigateToAddNote()
        }
    }

    private fun navigateToAddNote() {
        findNavController().navigate(R.id.addNoteFragment)
    }

    companion object {

        const val ADD_NOTE = "add_note"

        const val NOTE = "note"
    }
}