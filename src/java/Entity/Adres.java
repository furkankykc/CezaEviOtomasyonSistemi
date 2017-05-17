/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *+---------+-------------+------+-----+---------+----------------+
 *| Field   | Type        | Null | Key | Default | Extra          |
 *+---------+-------------+------+-----+---------+----------------+
 *| id      | int(11)     | NO   | PRI | NULL    | auto_increment |
 *| binaNo  | int(11)     | YES  |     | NULL    |                |
 *| mahalle | varchar(20) | YES  |     | NULL    |                |
 *+---------+-------------+------+-----+---------+----------------+
 * @author furkankykc
 */
public class Adres {
    private int id;
    private int binaNo;
    private String mahalle;

    public Adres(int id, int binaNo, String mahalle) {
        this.id = id;
        this.binaNo = binaNo;
        this.mahalle = mahalle;
    }

    public Adres(int binaNo, String mahalle) {
        this.binaNo = binaNo;
        this.mahalle = mahalle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBinaNo() {
        return binaNo;
    }

    public void setBinaNo(int binaNo) {
        this.binaNo = binaNo;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    @Override
    public String toString() {
        return "adres{" + "id=" + id + ", binaNo=" + binaNo + ", mahalle=" + mahalle + '}';
    }
    
}
