import java.util.HashMap;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
//        total_pembelian();
//        simple_gui_input();
//        try_an_array();
    }

    public static void total_pembelian() {
        Scanner scanner = new Scanner(System.in);
        float diskon = 0;
        float potongan;
        float total_akhir;

        System.out.println("==========TOKO BERKAH SEJAHTERA==========");
        System.out.println("Masukkan Total Pembelian: ");
        float total_pembelian = scanner.nextFloat();
        scanner.nextLine();

        if (total_pembelian < 75000) {
            diskon = 10;
        } else if (total_pembelian >= 75000 && total_pembelian <= 100000) {
            diskon = 20;
        } else if (total_pembelian > 100000) {
            diskon = 30;
        }

        potongan = (diskon /100) * total_pembelian;
        total_akhir = total_pembelian - potongan;

        System.out.println("Total Pembelian: Rp. " + total_pembelian);
        System.out.println("Diskon: " + diskon + "%");
        System.out.println("Potongan: " + potongan);
        System.out.println("Total Akhir: Rp. " + total_akhir);
    }

    static void simple_gui_input() {
        String name = JOptionPane.showInputDialog("Enter Your Name");
        JOptionPane.showMessageDialog(null, "Hello " + name);
    }

    static void try_an_array() {
        String[] cars = {"volvo", "bmw", "honda"};
        for (String car : cars) {
            System.out.println(car);
        }

        HashMap<String, String> has = new HashMap<String, String>();
    }
}
