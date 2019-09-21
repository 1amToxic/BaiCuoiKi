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
//(mã sách, Tên sách, Tác giả, Chuyên ngành, Năm xuất bản,Số lượn)
public class Sach implements Serializable{
    private int idSach;
    public static int idSachAuto = 10000;
    private String nameB,authorB,majorB,yearB,quantityB;

    public Sach(String nameB, String authorB, String majorB, String yearB, String quantityB) {
        this.idSach = idSachAuto++;
        this.nameB = nameB;
        this.authorB = authorB;
        this.majorB = majorB;
        this.yearB = yearB;
        this.quantityB = quantityB;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public String getAuthorB() {
        return authorB;
    }

    public void setAuthorB(String authorB) {
        this.authorB = authorB;
    }

    public String getMajorB() {
        return majorB;
    }

    public void setMajorB(String majorB) {
        this.majorB = majorB;
    }

    public Sach() {
    }

    public String getYearB() {
        return yearB;
    }

    public void setYearB(String yearB) {
        this.yearB = yearB;
    }

    public String getQuantityB() {
        return quantityB;
    }

    public void setQuantityB(String quantityB) {
        this.quantityB = quantityB;
    }

    @Override
    public String toString() {
        return "Sach{" + "idSach=" + idSach + ", nameB=" + nameB + ", authorB=" + authorB + ", majorB=" + majorB + ", yearB=" + yearB + ", quantityB=" + quantityB + '}';
    }
    
}
