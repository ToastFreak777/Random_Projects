package Deep_Practice_With_Lists_Sets_Maps.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice6 {
    /*
     * Write a function that merges two sorted lists into a new sorted list.
     * [1,4,6],[2,3,5] → [1,2,3,4,5,6]. You can do this quicker than concatenating
     * them followed by a sort.
     */

    public static void main(String[] args) {
        // Concatenate then sort
        List<Integer> list1 = new ArrayList<>();

        Collections.addAll(list1, 1, 4, 6);
        List<Integer> list2 = new ArrayList<>(list1);
        Collections.addAll(list2, 2, 3, 5);

        Collections.sort(list2);
        System.out.println(list2);

    }
}