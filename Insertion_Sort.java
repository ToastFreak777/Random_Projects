package Sorting_Algorithms;

import java.util.Arrays;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 7, 8, 1, 3, 6 };

        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            if (nums[i] < nums[j]) {
                while (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    if (j != 0) {
                        j--;
                        i--;
                    } else {
                        i--;
                    }
                }
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
    }
}
