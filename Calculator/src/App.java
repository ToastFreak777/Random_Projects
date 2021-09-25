import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        try (Scanner uInput = new Scanner(System.in);) {
            System.out.println(
                    "What type of operation do you want to do?\n1.Sum\n2.Difference\n3.Product\n4.Quotient\n5.Power\n6.SqrRoot\n7.Percentage");

            int mode = uInput.nextInt();
            Integer num1, num2;
            switch (mode) {
                case 1:
                    System.out.print("Pick two numbers to add: ");
                    num1 = uInput.nextInt();
                    num2 = uInput.nextInt();

                    System.out.println(sumOfTwoNumbers.apply(num1, num2));
                    break;

                case 2:
                    System.out.print("Pick two numbers to subtract: ");
                    num1 = uInput.nextInt();
                    num2 = uInput.nextInt();

                    System.out.println(differenceOfTwoNumbers.apply(num1, num2));
                    break;

                case 3:
                    System.out.print("Pick two numbers to multiply: ");
                    num1 = uInput.nextInt();
                    num2 = uInput.nextInt();

                    System.out.println(productOfTwoNumbers.apply(num1, num2));
                    break;

                case 4:
                    System.out.print("Pick two numbers to divide: ");
                    Float num3 = uInput.nextFloat();
                    Float num4 = uInput.nextFloat();

                    System.out.println(quotientOfTwoNumbers.apply(num3, num4));
                    break;

                case 5:
                    System.out.print("Pick a number to square it: ");
                    num1 = uInput.nextInt();

                    System.out.println(powerOfNumber.apply(num1));
                    break;

                case 6:
                    System.out.print("Pick a number to find its squareroot :");
                    Double num5 = uInput.nextDouble();

                    System.out.println(squareRootOfNumber.apply(num5));

                case 7:
                    System.out.print("Pick a number to turn it into a percentage: ");
                    num3 = uInput.nextFloat();

                    System.out.println(percentageOfNumber.apply(num3) + "%");
                    break;

                default:
                    System.out.println("Invalid option please restart and try again");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Something went BOOM...");
        }
    }

    static BiFunction<Integer, Integer, Integer> sumOfTwoNumbers = (num1, num2) -> (num1 + num2);
    static BiFunction<Integer, Integer, Integer> differenceOfTwoNumbers = (num1, num2) -> (num1 - num2);
    static BiFunction<Integer, Integer, Integer> productOfTwoNumbers = (num1, num2) -> (num1 * num2);
    static BiFunction<Float, Float, Float> quotientOfTwoNumbers = (num1, num2) -> (num1 / num2);

    static Function<Integer, Integer> powerOfNumber = num1 -> (num1 * num1);
    static Function<Float, Float> percentageOfNumber = num1 -> (num1 / 100);
    static Function<Double, Double> squareRootOfNumber = num1 -> (Math.sqrt(num1));
}
