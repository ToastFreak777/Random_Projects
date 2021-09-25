package Deep_Practice_With_Lists_Sets_Maps.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Practice2 {
    // Write function that reverses a list, preferably in place.
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            rnd.setSeed(rnd.nextInt(1000));
            list.add(rnd.nextInt(100));
        }

        for (Integer i : list) {
            System.out.println(i);
        }

        Collections.reverse(list);

        System.out.println("Reverse order");
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
