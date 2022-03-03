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
import kotlinx.android.synthetic.main.fragment_question.*

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
            // 답이 맞은 경우 (3번을 체크)
            que_ans_03_btn.setOnClickListener{
                que_ans_01_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                que_ans_02_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                que_ans_03_btn.setBackgroundColor(resources.getColor(R.color.question_skyblue))
                que_ans_04_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                questionClearBtn.setOnClickListener{
                    navController.navigate(R.id.action_questionFragment_to_signupSelectFragment)
                }
            }

            // 틀린 답을 고르고, 다음을 누른 경우
            que_ans_01_btn.setOnClickListener {
                que_ans_01_btn.setBackgroundColor(resources.getColor(R.color.question_skyblue))
                que_ans_02_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                que_ans_03_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                que_ans_04_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                questionClearBtn.setOnClickListener {
                    Toast.makeText(requireContext(), "오답입니다.", Toast.LENGTH_SHORT).show()
                }
            }

            que_ans_02_btn.setOnClickListener {
                que_ans_01_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                que_ans_02_btn.setBackgroundColor(resources.getColor(R.color.question_skyblue))
                que_ans_03_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                que_ans_04_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                questionClearBtn.setOnClickListener {
                    Toast.makeText(requireContext(), "오답입니다.", Toast.LENGTH_SHORT).show()
                }
            }

            que_ans_04_btn.setOnClickListener {
                que_ans_01_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                que_ans_02_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                que_ans_03_btn.setBackgroundColor(resources.getColor(R.color.question_gray))
                que_ans_04_btn.setBackgroundColor(resources.getColor(R.color.question_skyblue))
                questionClearBtn.setOnClickListener {
                    Toast.makeText(requireContext(), "오답입니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}