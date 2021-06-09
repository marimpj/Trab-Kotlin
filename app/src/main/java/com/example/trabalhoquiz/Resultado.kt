package com.example.trabalhoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.trabalhoquiz.databinding.ActivityMainBinding
import com.example.trabalhoquiz.databinding.ActivityResultadoBinding
import kotlinx.android.synthetic.main.activity_resultado.*

class Resultado : AppCompatActivity() {

    lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()

        //setContentView(R.layout.activity_resultado)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName=intent.getStringExtra(setData.nome)
        val pontos=intent.getStringExtra(setData.pontos)
        val totalQuestao=intent.getStringExtra("total")

        congo.text = "Parabens ${userName} !! "
        Score.text = "${pontos} / ${totalQuestao}"
        button.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}