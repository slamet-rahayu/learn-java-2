import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class testcollection {
    public static void main(String[] args) {

        ArrayList<Map> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Map<String, String> arrobj = new HashMap<>();
            for (int uwu = 0; uwu < 5; uwu++) {
                arrobj.put("idx_" + i + "_" + uwu, "val_" + i + "_" +uwu);
            }
            arr.add(arrobj);
        }

        System.out.println(arr.get(2).get("idx_2_0"));

    }
}
