package com.ben.boonya.fragmentresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ben.boonya.fragmentresult.databinding.FragmentAddNoteBinding

class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            navigateBack()
        }
    }

    private fun navigateBack() {

        findNavController().previousBackStackEntry?.savedStateHandle?.set(
            NoteListFragment.ADD_NOTE,
            binding.editText.text.toString()
        )

        findNavController().popBackStack()
    }
}
