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


    public Pergunta(String descricao, String alternativaA, String alternativaB, String alternativaC, String alternativaCorreta, int imagem, boolean isGif){
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaCorreta = alternativaCorreta;
        this.descricao = descricao;

        this.imagem =  imagem;
        this.isGif =  isGif;
    }
    public Pergunta(String descricao, String alternativaA, String alternativaB, String alternativaC, String alternativaCorreta, int imagem, boolean isGif, int audio){
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
        this.alternativaCorreta = alternativaCorreta;
        this.descricao = descricao;
        this.audio = audio;
        this.imagem =  imagem;
        this.isGif =  isGif;
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

    public boolean isGif() { return isGif; }

    public void setGif(boolean gif) { isGif = gif; }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

}
