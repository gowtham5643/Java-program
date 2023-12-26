package placement_training;
import java.util.Scanner;

public class CalculateAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first floating-point number: ");
        double number1 = scanner.nextDouble();
        System.out.print("Enter the second floating-point number: ");
        double number2 = scanner.nextDouble();
        double average = (number1 + number2) / 2;
        System.out.printf("The average of %.2f and %.2f is: %.2f%n", number1, number2, average);
        scanner.close();
    }
}
