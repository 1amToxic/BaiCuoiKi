/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
class SinhVien implements Serializable{
    private int maSV;
    private String ten,lop;
    private double dtb;
    private String xeploai;

    public String getXeploai() {
        return xeploai;
    }

    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }
    public SinhVien() {
    }
    
    public SinhVien(int maSV, String ten, String lop, double dtb) {
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", ten=" + ten + ", lop=" + lop + ", dtb=" + dtb + '}';
    }
    
}


public class Main {
    public static void main(String[] args) {
        int choose = -1;
        
        List<SinhVien> list= new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        while(choose!=0){
            System.out.println("1.Doc sinh vien\n"
                    + "2.In danh sach sinh vien\n"
                    + "3.Sap xep theo lop \n"
                    + "4.Sap xep theo muc diem\n"
                    + "0.Thoat");
            choose = sc.nextInt();
            switch(choose){
                case 1:{
                    putData();
                    break;
                }
                case 2:{
                    list = getSV("SV.INP");
                    for(SinhVien sv: list)
                        System.out.println(sv);
                    break;
                }
                case 3:{
                    Collections.sort(list, new SortByDTB());
                    Collections.sort(list, new SortByClass());
                    putDataTo(list, "SV.OUT");
                    readData("SV.OUT");
                    break;
                }
                case 4:{
                    Collections.sort(list,new SortByName());
                    Collections.sort(list,new SortByDTB());
                    putDataTo(list, "XEPLOAI.OUT");
                    readData("XEPLOAI.OUT");
                    break;
                }
                case 0:{
                    break;
                }
                
            }
        }
        //putData();
    }
    public static void readData(String path){
        List<SinhVien> list = new ArrayList<>();
        list = getSV(path);
                    for(SinhVien sv: list)
                        System.out.println(sv);
    }
    public static void setXL(List<SinhVien> list){
        for(SinhVien sv: list){
            if(sv.getDtb()>8)   sv.setXeploai("Gioi");
            else if(sv.getDtb()>7) sv.setXeploai("Kha");
            else if(sv.getDtb()>5)  sv.setXeploai("TB");
            else sv.setXeploai("Yeu");
        }
    }
    public static void putData(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SV.INP"));
            oos.writeObject(new SinhVien(1000,"Nguyen Lam","D17",9));
            oos.writeObject(new SinhVien(1001,"Nguyen Aam","D16",9));
            oos.writeObject(new SinhVien(1000,"Nam Zam","D17",9));         
            oos.writeObject(new SinhVien(1003,"ZZZ AAA","D16",9));
            oos.writeObject(new SinhVien(1000,"Nguyen Nam","D17",9));
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void putDataTo(List<SinhVien> list, String path){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            for(SinhVien sv: list)
                oos.writeObject(sv);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static List<SinhVien> getSV(String path){
        List<SinhVien> listSV = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean cont = true;
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(cont){
                SinhVien sv = (SinhVien) ois.readObject();
                if(sv!=null){
                    try{
                        ExMaNV(sv.getMaSV());
                        ExString(sv.getTen());
                        ExString(sv.getLop());
                        ExDTB(sv.getDtb());
                        listSV.add(sv);
                    }catch(ExUsage e){
                        //
                    }
                }
                else cont = false;
            }
        } catch (Exception ex) {
           // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSV;
        
    }
    
    public static void ExMaNV(int s) throws ExUsage{
        if(s<1000||s>9999)  throw new ExUsage("");
    }
    public static void ExString(String s) throws ExUsage{
        if(s.length()==0)   throw new ExUsage(s);
    }
    public static void ExDTB(double d) throws ExUsage{
        if(d<0||d>10)   throw  new ExUsage("");
    }
}
class ExUsage extends Exception{
    public ExUsage(String mesage){
        super(mesage);
    }
}
class SortByDTB implements Comparator<SinhVien>{

    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        return o1.getDtb()>o2.getDtb() ? -1 : 1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
class SortByName implements Comparator<SinhVien>{

    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        String str1[] = o1.getTen().split(" ");
        String str2[] = o2.getTen().split(" ");
        if(str1[st1r1.length-1].equals(str2[str2.length-1])){
            return o2.getTen().compareTo(o1.getTen());
        }
        else return str1[str1.length-1].compareTo(str2[str2.length-1]);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
}
class SortByClass implements Comparator<SinhVien>{

    @Override
    public int compare(SinhVien o1, SinhVien o2) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return o1.getLop().compareTo(o2.getLop());
    }
    
}