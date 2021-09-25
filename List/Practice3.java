package Deep_Practice_With_Lists_Sets_Maps.List;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Practice3 {
    // Write a function that checks whether an element occurs in a list.
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();

        while (true) {

            if (list.contains(70000) == true || list.contains(30000) == true) {
                System.out.println("Found!");
                int remove1 = list.remove(91000);
                int remove2 = list.remove(31000);
                System.out.println("Removed " + remove1 + " and " + remove2);
                long end = System.currentTimeMillis();
                System.out.println("Time taken: " + (end - start) + "ms");
                break;
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 10000000; i++) {
            set.add(i);
        }
        long start2 = System.currentTimeMillis();

        while (true) {

            if (set.contains(70000) == true || set.contains(30000) == true) {
                System.out.println("Found!");
                int remove1 = list.remove(92000);
                int remove2 = list.remove(21000);
                System.out.println("Removed " + remove1 + " and " + remove2);
                long end2 = System.currentTimeMillis();
                System.out.println("Time taken: " + (end2 - start2) + "ms");
                break;
            }
        }

    }
}