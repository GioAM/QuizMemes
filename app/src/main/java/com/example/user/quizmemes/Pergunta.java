package com.example.user.quizmemes;

import android.content.res.AssetFileDescriptor;
import android.media.Image;
import android.media.SoundPool;

public class Pergunta {
    private String descricao;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaCorreta;
    private int imagem;
    private boolean isGif;
    private int audio;
    private int tempo;

    public Pergunta(String descricao, String alternativaA, String alternativaB, String alternativaC, String alternativaCorreta, int imagem){
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaCorreta = alternativaCorreta;
        this.descricao = descricao;
        this.tempo = 0;
        this.imagem = imagem;
    }
    public Pergunta(String descricao, String alternativaA, String alternativaB, String alternativaC, String alternativaCorreta, int imagem, int audio, int tempo){
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaCorreta = alternativaCorreta;
        this.descricao = descricao;
        this.tempo = tempo;
        this.audio = audio;
        this.imagem =  imagem;
    }

    public int getImagem() {
        return imagem;
    }
    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
    public String getAlternativaA() {
        return alternativaA;
    }
    public void setAlternativaA(String alternativaA) {
        this.alternativaA = alternativaA;
    }
    public String getAlternativaB() {
        return alternativaB;
    }
    public void setAlternativaB(String alternativaB) {
        this.alternativaB = alternativaB;
    }
    public String getAlternativaC() {
        return alternativaC;
    }
    public void setAlternativaC(String alternativaC) {
        this.alternativaC = alternativaC;
    }
    public String getAlternativaCorreta() {
        return alternativaCorreta;
    }
    public void setAlternativaCorreta(String alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getAudio() {
        return audio;
    }
    public void setAudio(int audio) {
        this.audio = audio;
    }
    public int getTempo() {
        return tempo;
    }
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
