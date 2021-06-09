package com.example.trabalhoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.trabalhoquiz.databinding.ActivityMainBinding
import com.example.trabalhoquiz.databinding.ActivitySplashScreenBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        button.setOnClickListener{
            if(input.text.toString().isEmpty()){
                Toast.makeText(this, "Digite seu Nome: ", Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(this, Questoes::class.java)
                intent.putExtra("${setData.nome}",input.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}