package com.example.user.quizmemes

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.media.AudioManager
import java.sql.Time
import java.util.*

class Jogo : AppCompatActivity() {

    var perguntas :  ArrayList<Pergunta> = ArrayList<Pergunta>()
    var perguntaAtual = 0
    var som : SoundPool = criarObjetoDeSom();
    var vidas:Int = 3
    var nome = ""
    var idErro1 = 0
    var idErro2 = 0
    var idErro3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        perguntaAtual=0
        val gerenciadorDeAssets = assets
        setContentView(R.layout.activity_jogo)
        var pagInicial = getIntent()
        nome = pagInicial.getStringExtra("nome")
        perguntas.add(Pergunta("Quem a Xuxa mandou sentar?","Letícia","Cláudia","Jandira", R.id.botao2.toString(),  resources.getIdentifier("xuxa","mipmap",packageName), som.load(gerenciadorDeAssets.openFd("Aham-Claudia-Senta-La.mp3"),1),2000))
        perguntas.add(Pergunta("Qual console o menino histérico ganhou?","Nintendo 64","GameBoy Advanced","Playstation 1",R.id.botao1.toString(),resources.getIdentifier("nintendo","mipmap",packageName),som.load(gerenciadorDeAssets.openFd("64.mp3"),1),4500))
        perguntas.add(Pergunta("Como a Carla Beatriz vai ir a festa?","Um vestido, uma blusa amarrada, com a bota e o cabelo solto de prancha","Uma saia, com um croped  e o cabelo solto de prancha","Um vestido, com a blusa e o cabelo amarrados",R.id.botao1.toString(), resources.getIdentifier("vestido","mipmap",packageName),som.load(gerenciadorDeAssets.openFd("vestido.mp3"),1),7000))
        perguntas.add(Pergunta("","Glória a Deux","Aleluia Irmons","Amém",R.id.botao1.toString(), resources.getIdentifier("daciolo","mipmap",packageName), som.load(gerenciadorDeAssets.openFd("daciolo.mp3"),1),2000))
        perguntas.add(Pergunta("Qual morro o Marco Véio estava descendo?","Morro da Vó Teresina","Morro da tia Ernestina","Morro da Vó Salvelina",R.id.botao3.toString(), resources.getIdentifier("marco","mipmap",packageName),som.load(gerenciadorDeAssets.openFd("marco.mp3"),1),2000))
        perguntas.add(Pergunta("","Quero Caféééé","Quero Saúdeee","Quero filééééé",R.id.botao1.toString(), resources.getIdentifier("cafe","mipmap",packageName),som.load(gerenciadorDeAssets.openFd("cafe.mp3"),1),7000))
        perguntas.add(Pergunta("2+2","5","4","3",R.id.botao3.toString(), resources.getIdentifier("acertou","mipmap",packageName), som.load(gerenciadorDeAssets.openFd("miseravel.mp3"),1),4000))
        perguntas.add(Pergunta("Qual é a despedida mais sofrida?","Duas Pessoas que se amam","Clara e o Ovo","A mãe e o filho",R.id.botao2.toString(), resources.getIdentifier("fernando","mipmap",packageName)))
        perguntas.add(Pergunta("O que o aconteceu com Lazier Martins?","Abelha picou","Desmaiou","Tomou um choque",R.id.botao3.toString(), resources.getIdentifier("lazier","mipmap",packageName),som.load(gerenciadorDeAssets.openFd("lazier.mp3"),1),2000))
        perguntas.add(Pergunta("Quem Dilma está saudando?","a mandioca","o Lula","a tapioca",R.id.botao1.toString(), resources.getIdentifier("dilma","mipmap",packageName),som.load(gerenciadorDeAssets.openFd("mandioca.mp3"),1),4000))
        perguntas.add(Pergunta("Com o que a velinha confundiu o extase?","com Rivortril","com Viagra","com Paracetamol",R.id.botao2.toString(), resources.getIdentifier("velinha","mipmap",packageName)))
        perguntas.add(Pergunta("Segundo o Cabo Daciolo, qual é o plano de Ciro Gomes?","Nova Ordem Mundial","Ursal","Foro de São Paulo",R.id.botao2.toString(), resources.getIdentifier("cabodaciolo","mipmap",packageName)))
        perguntas.add(Pergunta("","Ta pegando fogo no lixo","Ta pegando fogo nisso","Ta pegando fogo bicho",R.id.botao3.toString(), resources.getIdentifier("faustao","mipmap",packageName),som.load(gerenciadorDeAssets.openFd("fogo.mp3"),1),4000))
        var img = findViewById<ImageButton>(R.id.imagem)
        montarPergunta(img)
        idErro1 = som.load(gerenciadorDeAssets.openFd("erro1.mp3"),1);
        idErro2 = som.load(gerenciadorDeAssets.openFd("erro2.mp3"),1);
        idErro3 = som.load(gerenciadorDeAssets.openFd("erro3.mp3"),1);
    }
    fun jogar(view : View){
        val telaFinal = Intent(this, TelaFinal::class.java)
        if(view.id.toString().equals(perguntas[perguntaAtual].alternativaCorreta)){
            som.play(perguntas[perguntaAtual].audio,1f, 1f, 0, 0, 1f)
            if(perguntaAtual+1 == perguntas.size){
                rodarSql()
                telaFinal.putExtra("resultado","ganhou")
                startActivity(telaFinal)
                finish()
                return
            }
            findViewById<Button>(R.id.botao1).setText(perguntas[perguntaAtual].alternativaA)
            findViewById<Button>(R.id.botao2).setText(perguntas[perguntaAtual].alternativaB)
            findViewById<Button>(R.id.botao3).setText(perguntas[perguntaAtual].alternativaC)
            findViewById<TextView>(R.id.descricao).setText(perguntas[perguntaAtual].descricao)
            var img = findViewById<ImageButton>(R.id.imagem)
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    montarPergunta(img)
                }
            }, perguntas[perguntaAtual].tempo.toLong())
            perguntaAtual ++
        }else{
            vidas --
            if(vidas == 2){
                som.play(idErro3,1f, 1f, 0, 0, 1f)
                findViewById<ImageView>(R.id.hearth3).setImageResource(resources.getIdentifier(" ","mipmap",packageName))
            }else if(vidas == 1){
                som.play(idErro2,1f, 1f, 0, 0, 1f)
                findViewById<ImageView>(R.id.hearth2).setImageResource(resources.getIdentifier(" ","mipmap",packageName))
            }else if(vidas == 0){
                rodarSql()
                som.play(idErro1,1f, 1f, 0, 0, 1f)
                telaFinal.putExtra("resultado","perdeu")
                startActivity(telaFinal)
                finish()
            }
            var img = findViewById<ImageButton>(R.id.imagem)
            montarPergunta(img)
        }
    }
    fun montarPergunta(img : ImageButton){
        runOnUiThread {
            findViewById<Button>(R.id.botao1).setText(perguntas[perguntaAtual].alternativaA)
            findViewById<Button>(R.id.botao2).setText(perguntas[perguntaAtual].alternativaB)
            findViewById<Button>(R.id.botao3).setText(perguntas[perguntaAtual].alternativaC)
            findViewById<TextView>(R.id.descricao).setText(perguntas[perguntaAtual].descricao)
            findViewById<ImageButton>(R.id.imagem).setImageResource(perguntas[perguntaAtual].imagem)
        }

    }
    fun criarObjetoDeSom() : SoundPool {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return criarObjetoDeSomNovaVersao()
        }
        return criarObjetoDeSomVersaoVelha()
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    fun criarObjetoDeSomNovaVersao() : SoundPool {
        val atributos = AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build()
        som = SoundPool.Builder().setAudioAttributes(atributos).build()
        return som;
    }
    fun criarObjetoDeSomVersaoVelha () : SoundPool {
        return SoundPool(5, AudioManager.STREAM_MUSIC, 0)
    }
    fun rodarSql(){
        var total = (vidas + 1) * (perguntaAtual + 1)

        var banco = openOrCreateDatabase("QuizMemes", Context.MODE_PRIVATE, null)
        banco.execSQL("""
            INSERT INTO jogo ('nome', 'pontuacao')
            VALUES ('$nome', '$total')""")
        banco.close()
    }
}
