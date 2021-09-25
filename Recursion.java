package Practice;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(recursive_Add(5));

    }

    public static int recursive_Add(int number) {
        if (number == 0) {
            return 0;
        }
        return recursive_Add(number - 1) + number;
    }
}
