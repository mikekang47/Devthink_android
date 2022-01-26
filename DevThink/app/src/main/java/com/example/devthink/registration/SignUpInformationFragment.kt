package com.example.devthink.registration

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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        binding.signupRightBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpInformationFragment_to_signUpFinishFragment)
        }
        binding.signupLeftBtn.setOnClickListener {
            navController.navigate(R.id.action_signUpInformationFragment_to_signUpFragment)
        }



        // 지망생, 프론트엔드, 백엔드, 안드로이드, ios 선택



        // 기술 스택 자동완성
//        binding.searchBar.autoTv.threshold = 1 // 단어의 글자수가 1미만이면 무시
//
//        var stacks = arrayOf("html", "css", "javascript", "ruby", "python", "django", "php", "java", "spring", "node.js", "C", "C++", "C#")
//
//        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stacks)
//        binding.searchBar.autoTv.setAdapter(adapter)

    }


}