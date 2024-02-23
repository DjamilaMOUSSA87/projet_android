package sn.esmt.scolarite.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EtudiantResponce {
    @SerializedName("mat")
    @Expose
    private String  mat;
    @Expose
    private String nom;
    @Expose
    private String prenom;
    @Expose
    private String adr;
    @Expose
    private int tel;
    @Expose
    private double frais;

    public String getMat(String string) {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }
}
