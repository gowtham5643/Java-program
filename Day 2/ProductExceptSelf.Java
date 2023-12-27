package placement_training;
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        int[] result = new int[n];
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        rightProducts[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int[] output = productExceptSelf(input);
        System.out.print("[");
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
            if (i < output.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
