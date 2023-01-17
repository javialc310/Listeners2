package com.example.listeners2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.listeners2.databinding.ActivityMainBinding
/*
Hola
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activarBoton(binding)
        pulsarBoton(binding)
        textoFocus(binding)
    }

    fun activarBoton(binding: ActivityMainBinding) {
        binding.Text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.Text.text.isNotEmpty() && binding.Text2.text.isNotEmpty()) {
                    binding.button.isEnabled = true
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.Text2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.Text.text.isNotEmpty() && binding.Text2.text.isNotEmpty()) {
                    binding.button.isEnabled = true
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

    }

    fun pulsarBoton(binding: ActivityMainBinding) {
        binding.button.setOnClickListener {
            binding.Text.text.append(binding.Text2.text)
            binding.Text2.setText("")
            binding.button.isEnabled = false
        }
    }

    fun textoFocus(binding: ActivityMainBinding) {
        binding.Text.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textView.text = binding.Text.tag.toString()
            }
        }
        binding.Text2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textView.text = binding.Text2.tag.toString()
            }
        }
    }

}