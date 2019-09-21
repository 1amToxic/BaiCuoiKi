/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pakageFirst;

import java.io.Serializable;

/**
 *
 * @author dell
 */
//mã bạn đọc, Họ tên, địa chỉ, Số ĐT
public class BanDoc implements Serializable{

    public BanDoc() {
    }
    private int idBD;
    public static int idBDAuto = 10000;
    private String nameBD,addressBD,phoneBD;

    public BanDoc(String nameBD, String addressBD, String phoneBD) {
        this.idBD = idBDAuto++;
        this.nameBD = nameBD;
        this.addressBD = addressBD;
        this.phoneBD = phoneBD;
    }

    public int getIdBD() {
        return idBD;
    }

    @Override
    public String toString() {
        return "BanDoc{" + "idBD=" + idBD + ", nameBD=" + nameBD + ", addressBD=" + addressBD + ", phoneBD=" + phoneBD + '}';
    }
    
    public void setIdBD(int idBD) {
        this.idBD = idBD;
    }

    public String getNameBD() {
        return nameBD;
    }

    public void setNameBD(String nameBD) {
        this.nameBD = nameBD;
    }

    public String getAddressBD() {
        return addressBD;
    }

    public void setAddressBD(String addressBD) {
        this.addressBD = addressBD;
    }

    public String getPhoneBD() {
        return phoneBD;
    }

    public void setPhoneBD(String phoneBD) {
        this.phoneBD = phoneBD;
    }
    
}
