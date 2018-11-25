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
        perguntas.add(Pergunta("Quem a Xuxa mandou sentar?","Letícia","Cláudia","Jandira", R.id.botao2.toString(),  resources.getIdentifier("xuxa","mipmap",packageName), false))
        perguntas.add(Pergunta("Qual console o menino histérico ganhou?","Nintendo 64","GameBoy Advanced","Playstation 1",R.id.botao1.toString(),resources.getIdentifier("nintendo","mipmap",packageName),false))
        perguntas.add(Pergunta("Como a Carla Beatriz vai ir a festa?","Um vestido, uma blusa amarrada, com a bota e o cabelo solto de prancha","Uma saia, com um croped  e o cabelo solto de prancha","Um vestido, com a blusa e o cabelo amarrados",R.id.botao1.toString(), resources.getIdentifier("vestido","mipmap",packageName),false))
        perguntas.add(Pergunta("Clique na alternativa correta?","Glória a Deux","Aleluia Irmons","Amém",R.id.botao1.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        perguntas.add(Pergunta("Qual morro o Marco Véio estava descendo?","Morro da Vó Teresina","Morro da tia Ernestina","Morro da Vó Salvelina",R.id.botao3.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        perguntas.add(Pergunta("Clique na alternativa correta?","Quero Caféééé","Quero Saúdeee","Quero filééééé",R.id.botao1.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        perguntas.add(Pergunta("2+2","5","4","3",R.id.botao3.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        perguntas.add(Pergunta("Qual é a despedida mais sofrida?","Duas Pessoas que se amam","Clara e o Ovo","A mãe e o filho",R.id.botao2.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        perguntas.add(Pergunta("O que o aconteceu com Lazier Martins?","Abelha picou","Desmaiou","Tomou um choque",R.id.botao3.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        perguntas.add(Pergunta("Quem Dilma está saudando?","a mandioca","o Lula","a tapioca",R.id.botao1.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        perguntas.add(Pergunta("Com o que a velinha confundiu o extase?","com Rivortril","com Viagra","com Paracetamol",R.id.botao2.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        perguntas.add(Pergunta("Segundo o Cabo Daciolo, qual é o plano de Ciro Gomes?","Nova Ordem Mundial","Ursal","Foro de São Paulo",R.id.botao2.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
        perguntas.add(Pergunta("Clique na alternativa correta?","Ta pegando fogo no lixo","Ta pegando fogo nisso","Ta pegando fogo bicho",R.id.botao3.toString(), resources.getIdentifier("faustao","mipmap",packageName),false))
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
