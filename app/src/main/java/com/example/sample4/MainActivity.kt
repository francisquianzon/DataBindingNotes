package com.example.sample4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.sample4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Enter name")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.submitButton.setOnClickListener(){
            addNickname(it)
        }
    }

    private fun addNickname(view: View){


//        binding.nameLabel.text = binding.editText.text.toString()
//        binding.editText.visibility = View.GONE
//        binding.submitButton.visibility = View.GONE

        binding.apply{
            myName?.name = editText.text.toString()
            invalidateAll()
            editText.visibility = View.GONE
            submitButton.visibility = View.GONE
            nameLabel.visibility = View.VISIBLE
        }

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }

}
