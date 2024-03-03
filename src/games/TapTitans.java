package games;

import java.util.ArrayList;

public class TapTitans {

    public static ArrayList<Integer> arr = new ArrayList<>();

    TapTitans() {
        arr.add(10);
        System.out.println("init");
    }

    public static void main(String[] args) {
        TapTitans tapTitans = new TapTitans();
        tapTitans.printArr();
    }

    public void printArr() {
        System.out.println(arr);
    }
}
