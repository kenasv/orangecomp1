package com.asuscomm.orangecomp1.allbd;

import javax.persistence.*;

@Entity
public class Site {
    @Id
    private String id;
    private String diapazon;
    private String adres;
    private String infrastructura;
    private String prinadlegnost;
    private String dostup;
    private String kluch;
    private String aparatnaa;
    private String ad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;



    public  Site(){

    }

    public Site(String id, String adres, User user) {
        this.id = id;
        this.adres = adres;
        this.author = user;
    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDiapazon(String diapazon) {
        this.diapazon = diapazon;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setInfrastructura(String infrastructura) {
        this.infrastructura = infrastructura;
    }

    public void setPrinadlegnost(String prinadlegnost) {
        this.prinadlegnost = prinadlegnost;
    }

    public void setDostup(String dostup) {
        this.dostup = dostup;
    }

    public void setKluch(String kluch) {
        this.kluch = kluch;
    }

    public void setAparatnaa(String aparatnaa) {
        this.aparatnaa = aparatnaa;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getDiapazon() {
        return diapazon;
    }

    public String getAdres() {
        return adres;
    }

    public String getInfrastructura() {
        return infrastructura;
    }

    public String getPrinadlegnost() {
        return prinadlegnost;
    }

    public String getDostup() {
        return dostup;
    }

    public String getKluch() {
        return kluch;
    }

    public String getAparatnaa() {
        return aparatnaa;
    }

    public String getAd() {
        return ad;
    }

    public User getAuthor(){
        return author;
    }

    public void  setAuthor(User author){
        this.author = author;
    }



}
