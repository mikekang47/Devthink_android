package com.example.devthink.registration

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.devthink.R
import com.example.devthink.databinding.FragmentSignUpInformationBinding
import android.widget.ArrayAdapter
import com.example.devthink.Data.User
import kotlinx.android.synthetic.main.fragment_sign_up_information.*
import kotlinx.android.synthetic.main.search_bar.view.*

class SignUpInformationFragment : Fragment() {

    lateinit var binding: FragmentSignUpInformationBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpInformationBinding.inflate(inflater, container, false)
        return binding.root
    }
    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.signupRightBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpInformationFragment_to_signUpFinishFragment)
        }
        binding.signupLeftBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpInformationFragment_to_signUpFragment)
        }



        // 지망생, 프론트엔드, 백엔드, 안드로이드, ios 버튼 클릭
        var job = ""
        binding.signupJobStuBtn.setOnClickListener {
            binding.signupJobStuBtn.setBackgroundColor(R.color.skyblue)
            job = binding.signupJobStuBtn.text.toString()
        }

        binding.signupJobFrontBtn.setOnClickListener {
            binding.signupJobFrontBtn.setBackgroundColor(R.color.skyblue)
            job = binding.signupJobFrontBtn.text.toString()
        }

        binding.signupJobBackBtn.setOnClickListener {
            binding.signupJobBackBtn.setBackgroundColor(R.color.skyblue)
            job = binding.signupJobBackBtn.text.toString()
        }

        binding.signupJobAndroidBtn.setOnClickListener {
            binding.signupJobAndroidBtn.setBackgroundColor(R.color.skyblue)
            job = binding.signupJobAndroidBtn.text.toString()
        }

        binding.signupJobIosBtn.setOnClickListener {
            binding.signupJobIosBtn.setBackgroundColor(R.color.skyblue)
            job = binding.signupJobIosBtn.text.toString()
        }


        // 기술 스택 자동완성
//        binding.searchBar.autoTv.threshold = 1 // 단어의 글자수가 1미만이면 무시
//
//        var stacks = arrayOf("C/C++", "Java", "Python", "Kotlin", "Swift", "JavaScript",
//                            "Spring", "Node.js", "React", "Vue", "MySQL", "MariaDB", "MongoDB", "Redis")

//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stacks)
//        search_bar.auto_tv.setAdapter(adapter)

    }

}