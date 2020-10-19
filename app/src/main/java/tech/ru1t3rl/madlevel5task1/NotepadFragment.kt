package tech.ru1t3rl.madlevel5task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_notepad.*
import tech.ru1t3rl.madlevel5task1.databinding.FragmentNotepadBinding

class NotepadFragment : Fragment() {
    private lateinit var binding: FragmentNotepadBinding

    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotepadBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeAddNoteResult()
    }


    private fun observeAddNoteResult() {
        viewModel.note.observe(viewLifecycleOwner, { note ->
            note?.let {
                tvNoteTitle.text = it.titleText
                tvLastUpdated.text = it.lastUpdated.toString()
                tvNoteText.text = it.text
            }
        })
    }



}