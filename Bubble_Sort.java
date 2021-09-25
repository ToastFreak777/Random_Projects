package Sorting_Algorithms;

import java.util.Arrays;
import java.util.Random;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        numbers = random_Fill(numbers);

        // Sort
        for (int i = 0; i < numbers.length; i++) {
            for (int n = 0; n < i + 1; n++) {
                if (numbers[n] > numbers[i]) {
                    int temp = numbers[n];
                    numbers[n] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        Arrays.stream(numbers).forEach(System.out::println);
    }

    static int[] random_Fill(int[] arr) {
        Random rnd = new Random();
        rnd.setSeed(rnd.nextInt(500));

        for (int a = 0; a < arr.length; a++) {
            arr[a] = rnd.nextInt(100);
        }

        return arr;
    }
}
