package com.alekseykostyunin.hw_quiz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alekseykostyunin.hw_quiz.databinding.FragmentPollBinding

class Poll : Fragment() {

    private var _binding: FragmentPollBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPollBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toAnswer.setOnClickListener {
            val result = getResultAnswer()
            val bundle = Bundle()
            bundle.putInt(TAG_RESULT, result)
            findNavController().navigate(R.id.action_poll_to_result, bundle)
        }
        binding.toBack.setOnClickListener {
            findNavController().navigate(R.id.action_poll_to_welcome)
        }
    }

    private fun getResultAnswer(): Int {
        var result = 0
        if (binding.radioGroup.checkedRadioButtonId == binding.radioButtonTree.id) result++
        if (binding.radioGroup2.checkedRadioButtonId == binding.radioButtonTwo2.id) result++
        if (binding.radioGroup3.checkedRadioButtonId == binding.radioButtonTwo3.id) result++
        Log.i("TEST_result", result.toString())
        return result
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG_RESULT = "TAG_RESULT"
    }

}