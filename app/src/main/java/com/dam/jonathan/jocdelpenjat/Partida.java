package com.dam.jonathan.jocdelpenjat;

public class Partida {
    public int index = 0;
    public Partida(String paraula, String nom) {
        Paraula = paraula;
        ParaulaDisplayed = crea(paraula.length());
        Nom = nom;
    }

    public String getParaulaDisplayed() {
        return ParaulaDisplayed;
    }

    public void setParaulaDisplayed(String paraulaDisplayed) {
        ParaulaDisplayed = paraulaDisplayed;
    }

    public Partida(String paraula, String nom, String pista) {
        Paraula = paraula;
        Nom = nom;
        this.ParaulaDisplayed = crea(paraula.length());

        this.pista = pista;
        comproba(pista);
    }
    private String crea(int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('_');
            sb.append(' ');

        }
        return sb.toString();

    }

    private String Paraula;
    private String Nom;
    private String[] llistaLLetres = new String[6];
    private String ParaulaDisplayed ;

    public String getParaula() {
        return Paraula;
    }

    public void setParaula(String paraula) {
        Paraula = paraula;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String[] getLlistaLLetres() {
        return llistaLLetres;
    }

    public void setLlistaLLetres(String[] llistaLLetres) {
        this.llistaLLetres = llistaLLetres;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    private String pista =  "";

    public boolean comproba(String a) {
        StringBuilder sb = new StringBuilder(ParaulaDisplayed);
        int index = Paraula.indexOf(a);
        while (index != -1) {
            sb.setCharAt(index * 2, a.charAt(0));
            index = Paraula.indexOf(a, index + 1);
        }
        ParaulaDisplayed = sb.toString();
        return  Paraula.indexOf(a) !=-1;

    }
    public boolean miraGuanyador(){
        return ParaulaDisplayed.indexOf("-") !=-1;
    }






}
