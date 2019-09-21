/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakageFirst;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author dell
 */
public class QLMS implements Serializable{
    private int idBD;

    public int getIdBD() {
        return idBD;
    }

    public QLMS() {
    }
    
    public void setIdBD(int idBD) {
        this.idBD = idBD;
    }
    private String tenbandoc;
    private String tenSach;
    private int soluong;

    public String getTenbandoc() {
        return tenbandoc;
    }

    public void setTenbandoc(String tenbandoc) {
        this.tenbandoc = tenbandoc;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
}
