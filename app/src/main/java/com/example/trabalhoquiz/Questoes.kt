package com.example.trabalhoquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.MessageQueue
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.trabalhoquiz.databinding.ActivityQuestoesBinding
import kotlinx.android.synthetic.main.activity_questoes.*
import org.json.JSONObject

class Questoes : AppCompatActivity() {

    lateinit var binding: ActivityQuestoesBinding

    private var Nome:String?=null
    private var pontos:Int=0

    private var posicaoAtual:Int = 0
    private var listaQuestoes:ArrayList<Data>?=null
    private var opcaoSelecionada:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_questoes)

        Nome=intent.getStringExtra(setData.nome)

        binding = ActivityQuestoesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        listaQuestoes=setData.getQuestao()
        setQuestao()

        opt1.setOnClickListener{
            estiloOptSelecionada(opt1, 1)
        }
        opt2.setOnClickListener{
            estiloOptSelecionada(opt2, 2)
        }
        opt3.setOnClickListener{
            estiloOptSelecionada(opt3, 3)
        }
        opt4.setOnClickListener{
            estiloOptSelecionada(opt4, 4)
        }

        submit.setOnClickListener{
            if(opcaoSelecionada != 0){
                val questao = listaQuestoes!![posicaoAtual]
                if(opcaoSelecionada!=questao.resp){
                    setCor(opcaoSelecionada, R.drawable.resposta_errada)
                } else{
                    val userName=intent.getStringExtra(setData.nome)
                    lateinit var queue: RequestQueue
                    queue = Volley.newRequestQueue(this)
                    val URL = "https://7c2bad50.us-south.apigw.appdomain.cloud/api/placar"
                    val param = JSONObject()
                    param.put("usuario", userName )
                    val req = JsonObjectRequest(Request.Method.POST, URL, param, { response ->
                        Log.i("TRABALHO", response.toString())
                        },
                        {error->
                            Log.e("TRABALHO", error.toString())
                        }
                        )
                    queue.add(req)

                    pontos++;
                }

                setCor(questao.resp,R.drawable.resposta_certa)
                if(posicaoAtual == listaQuestoes!!.size){
                    submit.text = "Fim!"
                }
                else{
                    submit.text = "Proximo"
                }
            }
            else{
                posicaoAtual++
                when {
                    posicaoAtual <= listaQuestoes!!.size -1 -> {
                        setQuestao()
                    }
                    else -> {
                        var intent = Intent(this,Resultado::class.java)
                        intent.putExtra(setData.nome, Nome.toString())
                        intent.putExtra(setData.pontos, pontos.toString())
                        intent.putExtra("total",listaQuestoes!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            opcaoSelecionada = 0
        }
    }


    private fun setCor(opt:Int, color:Int){
        when(opt){
            1->{
                opt1.background=ContextCompat.getDrawable(this, color)
            }
            2->{
                opt2.background=ContextCompat.getDrawable(this, color)
            }
            3->{
                opt3.background=ContextCompat.getDrawable(this, color)
            }
            4->{
                opt4.background=ContextCompat.getDrawable(this, color)
            }
        }
    }

    fun setQuestao(){
        val questao = listaQuestoes!![posicaoAtual]
        setEstiloOpt()

        progress_bar.progress = posicaoAtual
        progress_bar.max = listaQuestoes!!.size
        progress_text.text = "${posicaoAtual}"+"/"+"${progress_bar.max}"
        question_text.text=questao.questao
        opt1.text=questao.opt1
        opt2.text=questao.opt2
        opt3.text=questao.opt3
        opt4.text=questao.opt4
    }

    fun setEstiloOpt(){
        var optList:ArrayList<TextView> = arrayListOf()
        optList.add(0, opt1)
        optList.add(1, opt2)
        optList.add(2, opt3)
        optList.add(3, opt4)

        for(opt in optList){
            //Checar cores
            opt.setTextColor(Color.parseColor("#504E4E"))
            opt.background=ContextCompat.getDrawable(this, R.drawable.opcao_pergunta)
            opt.typeface= Typeface.DEFAULT
        }
    }

    fun estiloOptSelecionada(view: TextView, opt:Int){
        setEstiloOpt()
        opcaoSelecionada = opt
        view.background=ContextCompat.getDrawable(this, R.drawable.selecionar_opcao_pergunta)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}