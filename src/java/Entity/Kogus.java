/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author furkankykc
 * +--------+---------+------+-----+---------+----------------+
 *| Field  | Type    | Null | Key | Default | Extra          |
 *+--------+---------+------+-----+---------+----------------+
 *| id     | int(11) | NO   | PRI | NULL    | auto_increment |
 *| kat    | int(11) | YES  |     | NULL    |                |
 *| numara | int(11) | YES  |     | NULL    |                |
 *| binaNo | int(11) | YES  |     | NULL    |                |
 *+--------+---------+------+-----+---------+----------------+
 */
public class Kogus {
    private int id;
    private int kat;
    private int numara;
    private int binaNo;
    
    public Kogus(){
        this.id = 0;
        this.kat = 0;
        this.numara = 0;
        this.binaNo = 0;
    }

    public Kogus(int id, int kat, int numara, int binaNo) {
        this.id = id;
        this.kat = kat;
        this.numara = numara;
        this.binaNo = binaNo;
    }
    public Kogus(int kat, int numara, int binaNo) {
        this.id = 0;
        this.kat = kat;
        this.numara = numara;
        this.binaNo = binaNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKat() {
        return kat;
    }

    public void setKat(int kat) {
        this.kat = kat;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public int getBinaNo() {
        return binaNo;
    }

    public void setBinaNo(int binaNo) {
        this.binaNo = binaNo;
    }
    
    
    
}
