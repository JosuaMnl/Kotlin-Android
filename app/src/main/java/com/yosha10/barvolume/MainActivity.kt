package com.yosha10.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.yosha10.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
//    private lateinit var etWidth: EditText
//    private lateinit var etHeight: EditText
//    private lateinit var etLength: EditText
//    private lateinit var btnCalculate: Button
//    private lateinit var tvResult: TextView
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        etWidth = findViewById(R.id.et_width)
//        etHeight = findViewById(R.id.et_height)
//        etLength = findViewById(R.id.et_length)
//        btnCalculate = findViewById(R.id.btn_calculate)
//        tvResult = findViewById(R.id.tv_result)

        binding.btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.tvResult.text = result
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate) {
            val inputLength = binding.etLength.text.toString().trim()
            val inputWidth = binding.etWidth.text.toString().trim()
            val inputHeight = binding.etHeight.text.toString().trim()

//            Toast.makeText(applicationContext, "Tesssss", Toast.LENGTH_SHORT).show()
            var isEmptyFields = false

            if (inputHeight.isEmpty()){
                isEmptyFields = true
                binding.etHeight.error = "Field ini tidak boleh kosong"
            }
            if (inputLength.isEmpty()){
                isEmptyFields = true
                binding.etLength.error = "Field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()){
                isEmptyFields = true
                binding.etWidth.error = "Field ini tidak boleh kosong"
            }
            if (!isEmptyFields){
                val volume = inputLength.toDouble() * inputHeight.toDouble() * inputWidth.toDouble()
                binding.tvResult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.tvResult.text.toString())
    }
}