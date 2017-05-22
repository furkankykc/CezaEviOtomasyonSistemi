/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *+--------+-------------+------+-----+---------+----------------+
 *| Field  | Type        | Null | Key | Default | Extra          |
 *+--------+-------------+------+-----+---------+----------------+
 *| id     | int(11)     | NO   | PRI | NULL    | auto_increment |
 *| ad     | varchar(20) | YES  |     | NULL    |                |
 *| kalori | int(11)     | YES  |     | NULL    |                |
 *+--------+-------------+------+-----+---------+----------------+
 * @author furkankykc
 */
public class Yemek {
    private int id;
    private String ad;
    private int kalori;

    public Yemek(int id, String ad, int kalori) {
        this.id = id;
        this.ad = ad;
        this.kalori = kalori;
    }
    public Yemek(String ad, int kalori) {
        this.id = 0;
        this.ad = ad;
        this.kalori = kalori;
    }
    public Yemek() {
        this.id = 0;
        this.ad = null;
        this.kalori = 0;
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

    public int getKalori() {
        return kalori;
    }

    public void setKalori(int kalori) {
        this.kalori = kalori;
    }

    @Override
    public String toString() {
        return "Yemek{" + "id=" + id + ", ad=" + ad + ", kalori=" + kalori + '}';
    }
    
    
}
