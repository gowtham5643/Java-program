package placement_training;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MergeArrayWithPartitionOrder {

    public static int[] mergeWithPartitionOrder(int[] array, int partitionSize, int[] partitionOrder) {
        List<List<Integer>> partitions = new ArrayList<>();

        // Partition the array based on the given size
        for (int i = 0; i < array.length; i += partitionSize) {
            int end = Math.min(i + partitionSize, array.length);
            partitions.add(new ArrayList<>(Arrays.asList(Arrays.copyOfRange(array, i, end))));
        }

        // Sort the partitions based on the given order
        Collections.sort(partitions, (a, b) -> {
            int size = Math.min(a.size(), b.size());
            for (int i = 0; i < size; i++) {
                int cmp = Integer.compare(partitionOrder[i], partitionOrder[i]);
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(b.size(), a.size()); // Larger partitions come first
        });

        // Merge the sorted partitions into a single array
        List<Integer> mergedList = new ArrayList<>();
        for (List<Integer> partition : partitions) {
            mergedList.addAll(partition);
        }

        // Convert the List<Integer> to int[]
        int[] mergedArray = new int[mergedList.size()];
        for (int i = 0; i < mergedList.size(); i++) {
            mergedArray[i] = mergedList.get(i);
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the array
        System.out.print("Enter the array (space-separated integers): ");
        String arrayInput = scanner.nextLine();
        int[] array = Arrays.stream(arrayInput.split(" ")).mapToInt(Integer::parseInt).toArray();

        // Get user input for the partition size
        System.out.print("Enter the partition size: ");
        int partitionSize = scanner.nextInt();

        // Get user input for the partition order
        System.out.print("Enter the partition order (space-separated integers): ");
        scanner.nextLine(); // Consume the newline character
        String orderInput = scanner.nextLine();
        int[] partitionOrder = Arrays.stream(orderInput.split(" ")).mapToInt(Integer::parseInt).toArray();

        // Call the mergeWithPartitionOrder method
        int[] result = mergeWithPartitionOrder(array, partitionSize, partitionOrder);

        // Print the results
        System.out.println("Input Array: " + Arrays.toString(array));
        System.out.println("Partition Size: " + partitionSize);
        System.out.println("Partition Order: " + Arrays.toString(partitionOrder));
        System.out.println("Output Array: " + Arrays.toString(result));

        // Close the scanner
        scanner.close();
    }
}
