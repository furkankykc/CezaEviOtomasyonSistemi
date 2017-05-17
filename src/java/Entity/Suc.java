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
public class Suc {
    private int id;
    private String ad;
    private String suc_tanimi;
    
    public Suc(){
        this.id = 0;
        this.ad = null;
        this.suc_tanimi = null;
    }
    public Suc(int id, String ad, String suc_tanimi){
        this.id = id;
        this.ad = ad;
        this.suc_tanimi = suc_tanimi;
    }
    public Suc(String ad, String suc_tanimi){
        this.id = 0;
        this.ad = ad;
        this.suc_tanimi = suc_tanimi;
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

    public String getSuc_tanimi() {
        return suc_tanimi;
    }

    public void setSuc_tanimi(String suc_tanimi) {
        this.suc_tanimi = suc_tanimi;
    }

    @Override
    public String toString() {
        return "Suclar{" + "id=" + id + ", ad=" + ad + ", suc_tanimi=" + suc_tanimi + '}';
    }
    
}
