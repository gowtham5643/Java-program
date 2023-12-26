package placement_training;
import java.util.Scanner;

public class OddEvenArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] inputArray = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            inputArray[i] = scanner.nextInt();
        }
        int[] evenArray = new int[size];
        int[] oddArray = new int[size];

        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 0; i < size; i++) {
            if (inputArray[i] % 2 == 0) {
                evenArray[evenIndex++] = inputArray[i];
            } else {
                oddArray[oddIndex++] = inputArray[i];
            }
        }
        System.out.print("Even Elements: [");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenArray[i]);
            if (i < evenIndex - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");

        System.out.print("Odd Elements: [");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddArray[i]);
            if (i < oddIndex - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        scanner.close();
    }
}
