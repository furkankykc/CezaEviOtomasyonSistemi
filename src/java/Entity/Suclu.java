/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author furkankykc
 */
public class Suclu {
    private int id;
    private String ad;
    private int tc;
    private String kan_grubu;
    private int suc_id;
    private int kogus_id;
    private Date giris_tarih;
    private Date cıkıs_tarih;
    private Suc suc;
    private Kogus kogus;
    
    public Suclu(int id, String ad, int suc_id, int tc, int kogus_id, String kan_grubu, Date giris_tarih, Date cıkıs_tarih) {
        this.id = id;
        this.ad = ad;
        this.suc_id = suc_id;
        this.tc = tc;
        this.giris_tarih = giris_tarih;
        this.cıkıs_tarih = cıkıs_tarih;
        this.kogus_id = kogus_id;
        this.kan_grubu = kan_grubu;
    }   
    public Suclu(String ad, int suc_id, int tc, int kogus_id, String kan_grubu, Date giris_tarih, Date cıkıs_tarih) {
        this.id = 0;
        this.ad = ad;
        this.suc_id = suc_id;
        this.tc = tc;
        this.giris_tarih = giris_tarih;
        this.cıkıs_tarih = cıkıs_tarih;
        this.kogus_id = kogus_id;
        this.kan_grubu = kan_grubu;
    }
    public Suclu() {
        this.id = 0;
        this.ad = null;
        this.suc_id = 0;
        this.tc = 0;
        this.giris_tarih = null;
        this.cıkıs_tarih = null;
        this.kogus_id = 0;
        this.kan_grubu = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public Suc getSuc() {
        return suc;
    }

    public void setSuc(Suc suc) {
        this.suc = suc;
    }

    public Kogus getKogus() {
        return kogus;
    }

    public void setKogus(Kogus kogus) {
        this.kogus = kogus;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getSuc_id() {
        return suc_id;
    }

    public void setSuc_id(int suc_id) {
        this.suc_id = suc_id;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public Date getGiris_tarih() {
        return giris_tarih;
    }

    public void setGiris_tarih(Date giris_tarih) {
        this.giris_tarih = giris_tarih;
    }

    public Date getCıkıs_tarih() {
        return cıkıs_tarih;
    }

    public void setCıkıs_tarih(Date cıkıs_tarih) {
        this.cıkıs_tarih = cıkıs_tarih;
    }
//burayi düzelt
    public int getKogus_id() {
        return kogus_id;
    }
//burayi düzelt
    public void setKogus_id(int kogus_id) {
        this.kogus_id = kogus_id;
    }
//burayi düzelt
    public String getKan_grubu() {
        return kan_grubu;
    }
//burayi düzelt
    public void setKan_grubu(String kan_grubu) {
        this.kan_grubu = kan_grubu;
    }

    @Override
    public String toString() {
        return "Suclu{" + "id=" + id + ", ad=" + ad + ", suc_id=" + suc_id + ", tc=" + tc + ", giris_tarih=" + giris_tarih + ", c\u0131k\u0131s_tarih=" + cıkıs_tarih + ", kogus_id=" + kogus_id + ", kan_grubu=" + kan_grubu + '}';
    }
    
    
    
    
    
}
