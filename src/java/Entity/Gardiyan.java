/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
/**
 *
 * @author furkankykc
 * +----------+------------+------+-----+---------+----------------+
 *| Field    | Type       | Null | Key | Default | Extra          |
 *+----------+------------+------+-----+---------+----------------+
 *| id       | int(11)    | NO   | PRI | NULL    | auto_increment |
 *| tc       | bigint(20) | YES  | UNI | NULL    |                |
 *| rutbe_id | int(11)    | YES  | MUL | NULL    |                |
 *+----------+------------+------+-----+---------+----------------+

 */
public class Gardiyan {
    private int id;
    private int tc;
    private int rutbe_id;
    private String ad;
    private Rutbe rutbe;
    public Gardiyan(int id, String ad, int tc, int rutbe_id) {
        this.id = id;
        this.tc = tc;
        this.rutbe_id = rutbe_id;
        this.ad = ad;
    }
    public Gardiyan(int tc,String ad, int rutbe_id) {
        this.id = 0;
        this.tc = tc;
        this.rutbe_id = rutbe_id;
        this.ad = ad;
    }
    public Gardiyan() {
        this.id = 0;
        this.tc = 0;
        this.rutbe_id = 0;
        this.ad = null;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public int getRutbe_id() {
        return rutbe_id;
    }

    public void setRutbe_id(int rutbe_id) {
        this.rutbe_id = rutbe_id;
    }

    public Rutbe getRutbe() {
        if(rutbe_id!=0)
        return new DAO.rutbeDao().get(rutbe_id);
        return null;
    }

    public void setRutbe(int rutbe_id) {
        this.rutbe_id = rutbe_id;
    }

    @Override
    public String toString() {
        return "Gardiyan{" + "id=" + id + ", tc=" + tc + ", rutbe_id=" + rutbe_id + ", ad=" + ad + ", rutbe=" + rutbe + '}';
    }
    
}
