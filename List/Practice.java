package Deep_Practice_With_Lists_Sets_Maps.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

//1. Write a function that returns the largest element in a list.
public class Practice {
    public static void main(String[] args) {
        List<Integer> largest_Element = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Random rnd = new Random();
            rnd.setSeed(rnd.nextInt());

            largest_Element.add(rnd.nextInt(30));
        }

        for (int i : largest_Element) {
            System.out.println(i);
        }

        Collections.sort(largest_Element, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }

        });

        int max_Element = largest_Element.remove(largest_Element.size() - 1);
        System.out.println("Largest element in list: " + max_Element);

    }
}
