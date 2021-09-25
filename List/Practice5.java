package Deep_Practice_With_Lists_Sets_Maps.List;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Practice5 {
    /*
     * Write a function that concatenates two lists. [a,b,c], [1,2,3] →
     * [a,b,c,1,2,3]
     */

    /*
     * Write a function that combines two lists by alternatingly taking elements,
     * e.g. [a,b,c], [1,2,3] → [a,1,b,2,c,3].
     */
    public static void main(String[] args) {
        List<String> list_Heroes = new LinkedList<>();
        List<String> list_Powers = new LinkedList<>();

        Collections.addAll(list_Heroes, "Batman", "Superman", "Flash");
        Collections.addAll(list_Powers, "Gadgets", "Fly", "Speed");

        list_Heroes.addAll(list_Powers);

        System.out.println(list_Heroes);

        /* **********************Part Two **************************************** */
        list_Heroes.clear();
        Collections.addAll(list_Heroes, "Batman", "Superman", "Flash");

        Iterator<String> iterate = list_Powers.iterator();
        for (int i = 0; i < list_Powers.size(); i++) {
            list_Heroes.add(i + (i + 1), iterate.next().toString());
        }

        System.out.println(list_Heroes);

    }
}
