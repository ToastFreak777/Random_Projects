package Sorting_Algorithms;

import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] array = { 14, 33, 27, 10, 35, 19, 42, 44 };

        int[] sorted = selection_sort_ASC(array);

        for (int i : sorted) {
            System.out.println(i);
        }

    }

    public static int[] selection_sort_ASC(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }

            int tmp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = tmp;
        }

        return arr;
    }
}
