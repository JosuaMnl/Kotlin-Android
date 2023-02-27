package com.yosha10.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var evWidth: EditText
    private lateinit var evHeight: EditText
    private lateinit var evLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        evWidth = findViewById(R.id.et_lebar)
        evHeight = findViewById(R.id.et_tinggi)
        evLength = findViewById(R.id.et_panjang)
        btnCalculate = findViewById(R.id.btn_hitung)
        tvResult = findViewById(R.id.tv_hasil)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_hitung) {
            val inputLength = evLength.text.toString().trim()
            val inputWidth = evWidth.text.toString().trim()
            val inputHeight = evHeight.toString().trim()

            val volume = inputLength.toDouble() * inputHeight.toDouble() * inputWidth.toDouble()
            tvResult.text = volume.toString()

            var isEmptyFields = false

            if (inputHeight.isEmpty()){
                isEmptyFields = true
                evHeight.error = "Field ini tidak boleh kosong"
            }
            if (inputLength.isEmpty()){
                isEmptyFields = true
                evLength.error = "Field ini tidak boleh kosong"
            }
        }
    }
}