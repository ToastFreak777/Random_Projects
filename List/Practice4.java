package Deep_Practice_With_Lists_Sets_Maps.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Practice4 {
    // Write a function that returns the elements on odd positions in a list.
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 25; i < 50; i++) {
            if (i % 2 != 0) {
                list.add(i);
            }
        }

        Iterator<Integer> iterate = list.listIterator();

        try {
            while (iterate.hasNext()) {
                if (iterate.next() % 2 != 0) {
                    System.out.println(iterate.next());
                }

            }
        } catch (NoSuchElementException e) {
            System.out.println("No more elements to iterate");
        }
    }
}
