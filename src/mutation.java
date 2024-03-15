import java.util.ArrayList;
import java.util.Arrays;

public class mutation {
    public static void main(String[] args) {
        int[][] winPattern = {{1,2,3}, {4,5,6}, {7,8,9}, {1,5,9}, {2,5,8}};
        int[] arrSeleceted = {1,2,4,5};
        for(int[] win1: winPattern) {
            ArrayList<Integer> includes = new ArrayList<>();
            for (int win2: win1) {
                boolean isContain = Arrays.stream(arrSeleceted).anyMatch(i -> i == win2);
                if (isContain) {
                    includes.add(1);
                } else {
                    includes.add(0);
                }
            }
            if (!includes.contains(0)) {
                System.out.println("you win!");
            }
        }
//        ArrayList<Double> list_belanja = new ArrayList<Double>();
//        list_belanja.add(10000D);
//        list_belanja.add(20000D);
//        list_belanja.add(30000D);
//
//        for (double list:list_belanja) {
//            System.out.println(list);
//        }
    }

    boolean isWin() {
        return false;
    }
}
