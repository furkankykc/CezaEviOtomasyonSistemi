/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *+------------+--------------+------+-----+---------+-------+
 *| Field      | Type         | Null | Key | Default | Extra |
 *+------------+--------------+------+-----+---------+-------+
 *| suclu_id   | int(11)      | YES  | MUL | NULL    |       |
 *| doktor_adi | varchar(20)  | YES  |     | NULL    |       |
 *| sikayet    | varchar(200) | YES  |     | NULL    |       |
 *+------------+--------------+------+-----+---------+-------+
 *
 * @author furkankykc
 */
public class Revir_kaydi {
    private int id;
    private int suclu_id;
    private String doktor_adi;
    private String sikayet;

    public Revir_kaydi(int suclu_id, String doktor_adi, String sikayet) {
        this.id = 0;
        this.suclu_id = suclu_id;
        this.doktor_adi = doktor_adi;
        this.sikayet = sikayet;
    }
    public Revir_kaydi(int id,int suclu_id, String doktor_adi, String sikayet) {
        this.id = id;
        this.suclu_id = suclu_id;
        this.doktor_adi = doktor_adi;
        this.sikayet = sikayet;
    }
    public Revir_kaydi() {
        this.id = 0;
        this.suclu_id = 0;
        this.doktor_adi = null;
        this.sikayet = null;
    }
    public int getSuclu_id() {
        return suclu_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSuclu_id(int suclu_id) {
        this.suclu_id = suclu_id;
    }

    public String getDoktor_adi() {
        return doktor_adi;
    }

    public void setDoktor_adi(String doktor_adi) {
        this.doktor_adi = doktor_adi;
    }

    public String getSikayet() {
        return sikayet;
    }

    public void setSikayet(String sikayet) {
        this.sikayet = sikayet;
    }
    
}
