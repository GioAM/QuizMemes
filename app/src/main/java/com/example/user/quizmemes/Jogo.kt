package com.example.user.quizmemes

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class Jogo : AppCompatActivity() {

    var perguntas :  ArrayList<Pergunta> = ArrayList<Pergunta>()
    var perguntaAtual = 0

    var vidas:Int = 3


    var nome = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        perguntaAtual=0
        setContentView(R.layout.activity_jogo)
        var pagInicial = getIntent()
        nome = pagInicial.getStringExtra("nome")
        perguntas.add(Pergunta("Qual dessas falas é a do Faustão?","Você não sabe  nem eu","Acertou Miseravi","Tá pegando fogo bicho", R.id.botao3.toString(),  resources.getIdentifier("faustao","mipmap",packageName), false))
        perguntas.add(Pergunta("Qual é a A?","A","B","C",R.id.botao1.toString(),resources.getIdentifier("tenor","mipmap",packageName),true))
        perguntas.add(Pergunta("Qual é a B?","A","B","C",R.id.botao2.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        montarPergunta()
    }
    fun jogar(view : View){
        val telaFinal = Intent(this, TelaFinal::class.java)
        if(view.id.toString().equals(perguntas[perguntaAtual].alternativaCorreta)){
            if(perguntaAtual+1 == perguntas.size){
                telaFinal.putExtra("resultado","ganhou")
                startActivity(telaFinal)
                finish()
                return
            }
            perguntaAtual ++
        }else{
            vidas --
            if(vidas == 2){
                findViewById<ImageView>(R.id.hearth3).setImageResource(resources.getIdentifier(" ","mipmap",packageName))
            }else if(vidas == 1){
                findViewById<ImageView>(R.id.hearth2).setImageResource(resources.getIdentifier(" ","mipmap",packageName))
            }else if(vidas == 0){
                telaFinal.putExtra("resultado","perdeu")
                startActivity(telaFinal)
                finish()
            }
        }
        montarPergunta()
    }
    fun montarPergunta(){
        findViewById<TextView>(R.id.numeroDaPergunta).setText((perguntaAtual+1).toString())
        findViewById<Button>(R.id.botao1).setText(perguntas[perguntaAtual].alternativaA)
        findViewById<Button>(R.id.botao2).setText(perguntas[perguntaAtual].alternativaB)
        findViewById<Button>(R.id.botao3).setText(perguntas[perguntaAtual].alternativaC)
        findViewById<TextView>(R.id.descricao).setText(perguntas[perguntaAtual].descricao)
        if(perguntas[perguntaAtual].imagem == 0){
            findViewById<ImageButton>(R.id.imagem).setImageResource(resources.getIdentifier("ponto","mipmap",packageName))
            findViewById<ImageButton>(R.id.imagem).setVisibility(View.VISIBLE)
            findViewById<GifImageView>(R.id.gif).setVisibility(View.INVISIBLE)
        }else if(!perguntas[perguntaAtual].isGif){
            findViewById<ImageButton>(R.id.imagem).setImageResource(perguntas[perguntaAtual].imagem)
            findViewById<ImageButton>(R.id.imagem).setVisibility(View.VISIBLE)
            findViewById<GifImageView>(R.id.gif).setVisibility(View.INVISIBLE)
        }else if(perguntas[perguntaAtual].isGif){
            findViewById<GifImageView>(R.id.gif).setImageResource(perguntas[perguntaAtual].imagem)
            findViewById<ImageButton>(R.id.imagem).setVisibility(View.INVISIBLE)
            findViewById<GifImageView>(R.id.gif).setVisibility(View.VISIBLE)
        }
    }
}
