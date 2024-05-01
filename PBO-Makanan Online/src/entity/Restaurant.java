package entity;

import java.util.*;
import static utility.Input.*;

public class Restaurant {
    private String nama;
    private String alamat;
    private ArrayList<String> menu = new ArrayList<>();
    private ArrayList<Integer> harga = new ArrayList<>();

    public Restaurant(String nama, String alamat){
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void addMenu(String menu,int harga){
        this.menu.add(menu);
        this.harga.add(harga);
    }
    public String getMenu(int index){
        return menu.get(index);
    }
    public void setMenuName(int idMenu, String newName){
        this.menu.set(idMenu,newName);
    }public void setMenuharga(int idMenu, int newHarga){
        this.harga.set(idMenu,newHarga);
    }
    public void removeMenu(int idMenu){
        this.menu.remove(idMenu);
        this.harga.remove(idMenu);
    }

    public int getHarga(int index){
        return harga.get(index);
    }
    public int getTotalMenu(){
        return menu.size();
    }
    public void showAllMenu(){
        if (menu.size() == 0){
            System.out.println("\tRestauran ini tidak memiliki menu");
        }else {
            System.out.println("\tMenu :");
            for (int i = 0; i < menu.size(); i++) {
                System.out.printf("\t\t%d. %s\t\tRp.%d\n",i+1, menu.get(i), harga.get(i));
            }
        }
    }
    public void showData(){
        System.out.println(this.nama);
        System.out.println("\talamat : "+ this.alamat);
    }
    public void showAllData(){
        System.out.println(this.nama);
        System.out.println("\talamat : " + this.alamat);
        showAllMenu();
        System.out.println();
    }
}
