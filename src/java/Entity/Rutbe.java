/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author furkankykc
 */
public class Rutbe {
    private int id;
    private String ad;

    public Rutbe(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public Rutbe(String ad) {
        this.id = 0;
        this.ad = ad;
    }
    public Rutbe(){
        this.id = 0;
        this.ad = null;
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

    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Rutbe{" + "id=" + id + ", ad=" + ad + '}';
    }
    
    
}
