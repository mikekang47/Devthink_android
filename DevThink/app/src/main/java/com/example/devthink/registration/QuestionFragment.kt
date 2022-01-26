package com.example.devthink.registration

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.devthink.R
import com.example.devthink.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    lateinit var binding: FragmentQuestionBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.apply {
        // binding.queClearBtn.setOnClickListener {
            // 답이 맞은 경우 (3번을 체크)
            binding.queAns03Btn.setOnClickListener{
                binding.queAns01Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queAns02Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queAns03Btn.setBackgroundColor(resources.getColor(R.color.question_skyblue))
                binding.queAns04Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queClearBtn.setOnClickListener{
                    navController.navigate(R.id.action_questionFragment_to_signupSelectFragment)
                }
            }

            // 틀린 답을 고르고, 다음을 누른 경우
            binding.queAns01Btn.setOnClickListener {
                binding.queAns01Btn.setBackgroundColor(resources.getColor(R.color.question_skyblue))
                binding.queAns02Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queAns03Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queAns04Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queClearBtn.setOnClickListener {
                    Toast.makeText(requireContext(), "오답입니다.", Toast.LENGTH_SHORT).show()
                }
            }

            binding.queAns02Btn.setOnClickListener {
                binding.queAns01Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queAns02Btn.setBackgroundColor(resources.getColor(R.color.question_skyblue))
                binding.queAns03Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queAns04Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queClearBtn.setOnClickListener {
                    Toast.makeText(requireContext(), "오답입니다.", Toast.LENGTH_SHORT).show()
                }
            }

            binding.queAns04Btn.setOnClickListener {
                binding.queAns01Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queAns02Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queAns03Btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                binding.queAns04Btn.setBackgroundColor(resources.getColor(R.color.question_skyblue))
                binding.queClearBtn.setOnClickListener {
                    Toast.makeText(requireContext(), "오답입니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}