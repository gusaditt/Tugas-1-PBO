package menu;

import entity.Order;
import entity.Restaurant;
import static utility.Input.*;
import static data.Restaurants.*;
import java.util.ArrayList;
import static utility.console.clrscr;
class CusMenu {
    private static ArrayList<Order>orders = new ArrayList<>();
    public static void main(String[] args){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||              Menu Customer              ||");
        System.out.println("=============================================");
        System.out.println("[1]Buat Pesanan");
        System.out.println("[2]Lihat Pesanan");
        System.out.println("[3]Log Out");
        switch (inputInt("Masukan Pilihan",1,3)){
            case 1:
                buatPesanan();
                break;
            case 2:
                lihatPesanan();
                break;
            case 3:
                if (inputInt("anda yakin?\n[1]Ya\n[0]Tidak",0,1) == 1){
                    Login.main(null);
                }else {
                    main(null);
                }
        }
    }
    private static void buatPesanan(){
        clrscr();
        System.out.println("=============================================");
        System.out.println("||              Menu Customer              ||");
        System.out.println("||              Buat Pesanan               ||");
        System.out.println("=============================================");
        if (getListRestaurant().size() == 0){

            System.out.println("Tidak ada Restaurant!");
            inputInt("[1]Kembali",1,1);
            main(null);
        }else {
            for (int i = 0; i < getListRestaurant().size(); i++) {
                System.out.printf("%d.\t",i+1);
                getListRestaurant().get(i).showData();
                System.out.println(" ");
            }
            int idRestaurantSelected = inputInt("Pilih Restaurant\n[0]Kembali",0,getListRestaurant().size()) - 1;
            if (idRestaurantSelected == -1){//kembali ke menu
                main(null);
            }if (getListRestaurant().get(idRestaurantSelected).getTotalMenu() == 0){//mengecek apakah terdapat menu di restaurant terpilih
                System.out.println("Restaurant ini belum memiliki menu!");
                inputInt("[1]Kembali",1,1);
                buatPesanan();
            }else {
                int jarakAntar = inputInt("Masukan jarak antar lokasi anda",0);
                orders.add(new Order(idRestaurantSelected,jarakAntar));
                addMenuOrder(idRestaurantSelected,orders.size()-1);
                editMenuOrder(idRestaurantSelected,orders.size()-1);
                if (inputInt("Apakah ingin membuat Pesanan Lagi?\n[1]Ya\n[0]Tidak",0,1) == 1){
                    buatPesanan();
                }else {
                    main(null);
                }
            }
        }
    }

    private static void editMenuOrder(int idRestaurantSelected,int idOrderSelected){
        while (true){
            clrscr();
            showOrder(idOrderSelected);
            switch (inputInt("[1]Konfirmasi Pesanan\n[2]Tambah Menu\n[3]hapus Menu\n[4]Batalkan Pesanan",1,4)){
                case 2 :
                    addMenuOrder(idRestaurantSelected,idOrderSelected);
                    continue;
                case 3:
                    removeMenuOrder(idRestaurantSelected,idOrderSelected);
                    continue;
                case 4:
                    orders.remove(idOrderSelected);
                    break;
                case 1:
                    if (orders.get(idOrderSelected).getIdMenus().size() == 0){//mencegah terbuatnya order dengan 0 menu dipesan
                        inputInt("Untuk membuat Pesanan Setidaknya Ada 1 menu yang dipesan!\n[1]Kembali",1,1);
                        continue;
                    }
                    break;
            }
            break;
        }
    }
}
