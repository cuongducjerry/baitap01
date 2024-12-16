import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static Animal[] list;

    public static int n;
    public static int i2 = 0;

    public static void showInfo(){
        System.out.println("1. Nhập vào số lượng động vật trong sở thú.");
        System.out.println("2. Thêm động vật vào danh sách với số lượng bạn đã nhập");
        System.out.println("3. Hiển thị danh sách động vật.");
        System.out.println("4. Thêm con vật vào danh sách khi số lượng n bạn nhập đã đầy.");
        System.out.println("5. Nhập tên con vật, hiển thị thông tin con vật đó.");
        System.out.println("6. Cho phép xóa con vật theo tên.");
        System.out.println("7. Cập nhật con vật theo tên.");
        System.out.println("0. Thoát chương trình !!!");
    }

    public static String getString(String info){
        while(true){
            System.out.print(info);
            String s = sc.nextLine();
            if(s != null){
                return s;
            }
            else{
                System.err.print("(Nhập lại tên động vật) 0: ");
            }
        }
    }

    public static String updateString(String oldValue, String info){
        String result = oldValue;
        System.out.print(info);
        String tmp = sc.nextLine();
        if(!tmp.isEmpty()){
            result = tmp;
        }
        return result;
    }

    public static int updateInt(int oldValue, String info){
        int result = oldValue;
        boolean check = true;
        do{
            System.out.print(info);
            result = Integer.parseInt(sc.nextLine());
            check = false;
        }while(check);
        return result;
    }

    public static int nhapSoLuong(String info){
        while(true){
            System.out.print(info);
            n = Integer.parseInt(sc.nextLine());
            if(n > 0){
                System.out.println("Nhập n thành công!");
                return 0;
            }
            else{
                System.err.print("(Nhập lại số n > 0) : ");
            }
        }
    }

    public static int getInt(String info){
        while(true){
            System.out.print(info);
            int k = Integer.parseInt(sc.nextLine());
            if(k > 0){
                return k;
            }
            else{
                System.err.print("(Nhập lại số lớn hơn 0) : ");
            }
        }
    }

    public static void themConVatTheoSoLuongN(){
        list = new Animal[n];
        int cnt = 0;
        int cnt1 = 0;
        do{
            System.out.println("Con vật thứ " + ++cnt1 + " : ");
            String conVat = getString("Bạn chọn con vật nào (Lion, Elephant, Monkey) : ");
            String tenConVat = getString("Nhập vào tên của " + conVat + " : ");
            int tuoiConVat = getInt("Nhập vào tuổi của " + conVat + " : ");
            if(conVat.equals("Lion")){
                list[i2++] = new Lion(tenConVat, tuoiConVat);
            }
            else if(conVat.equals("Elephant")){
                list[i2++] = new Elephant(tenConVat, tuoiConVat);
            }
            else if(conVat.equals("Monkey")){
                list[i2++] = new Monkey(tenConVat, tuoiConVat);
            }
            ++cnt;
        }while(cnt != n);
        System.out.println("Bạn đã nhập đủ " + n + " con vật!");
    }

    public static void themConVatQuaSoLuongN(){
        Animal[] listNew;
        int c;
        do{
            listNew = new Animal[n+1];
            String conVat = getString("Bạn chọn con vật nào (Lion, Elephant, Monkey) : ");
            String tenConVat = getString("Nhập vào tên của " + conVat + " : ");
            int tuoiConVat = getInt("Nhập vào tuổi của " + conVat + " : ");
            for(int i = 0; i < n; i++){
                listNew[i] = list[i];
            }
            if(conVat.equals("Lion")){
                listNew[n] = new Lion(tenConVat, tuoiConVat);
            }
            else if(conVat.equals("Elephant")){
                listNew[n] = new Elephant(tenConVat, tuoiConVat);
            }
            else if(conVat.equals("Monkey")){
                listNew[n] = new Monkey(tenConVat, tuoiConVat);
            }
            n = n + 1;
            list = new Animal[n];
            for(int i = 0; i < n; i++){
                list[i] = listNew[i];
            }
            System.out.println("Bạn có muốn thêm động vật nữa không - (Chọn 1 để thêm tiếp, chọn 0 để thoát) !!!");
            c = Integer.parseInt(sc.nextLine());
        }while(c != 0);
    }

    public static void inDanhSach(){
        for(int i = 0; i < n; i++){
            System.out.println(list[i]);
        }
    }

    public static void hienThiThongTinConVatTheoTen(){
        String s = getString("Nhập vào tên con vật bạn muốn xem thông tin: ");
        for(int i = 0; i < n; i++){
            if(list[i].getName().equals(s)){
                System.out.println(list[i]);
            }
        }
    }

    public static void xoaConVat(){
        String conVatCanXoa = getString("Nhập vào tên con vật cần xóa: ");
        Animal[] animals = new Animal[n-1];
        int j = 0;

        boolean ok = false;
        for(int i = 0; i < n; i++){
            if(list[i].getName().equals(conVatCanXoa)){
                ok = true;
                continue;
            }
            else{
                animals[j++] = list[i];
            }
        }
        if(!ok){
            System.out.println("Tên con vật không có trong danh sách!");
            return;
        }
        else{
            n = n - 1;
            list = new Animal[n];
            for(int i = 0; i < n; i++){
                list[i] = animals[i];
            }
            System.out.println("Danh sách sau khi xóa con vật: ");
            for(int i = 0; i < n; i++){
                System.out.println(list[i]);
            }
        }
    }

    public static void update(){
        String tenConVatCapNhat = getString("Nhập tên con vật bạn muốn cập nhật: ");
        for(int i = 0; i < n; i++){
            if(list[i].getName().equals(tenConVatCapNhat)){
                list[i].updateAnimal();
            }
        }
        System.out.println("Danh sách sau khi cập nhật lại: ");
        for(int i = 0; i < n; i++){
            System.out.println(list[i]);
        }
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        int choice;
        do{
            Main.showInfo();
            choice = getInt("Nhập lựa chọn của bạn: ");
            switch(choice){
                case 1:
                    Main.nhapSoLuong("Nhập vào số lượng n: ");
                    break;
                case 2:
                    Main.themConVatTheoSoLuongN();
                    break;
                case 3:
                    Main.inDanhSach();
                    break;
                case 4:
                    Main.themConVatQuaSoLuongN();
                    break;
                case 5:
                    Main.hienThiThongTinConVatTheoTen();
                    break;
                case 6:
                    Main.xoaConVat();
                    break;
                case 7:
                    Main.update();
                    break;
            }
        }while(choice != 0);

    }
}
