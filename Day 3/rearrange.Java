package placement_training;

import java.util.Scanner;


public class rearrange {
    
 public void rearrange(int[] arr) {
        int left=0;
        int right=arr.length- 1;

        while(left<=right) 
        {
            while(left<=right&&arr[left]<0) 
            {
                left++;
            }

            while(left<=right&&arr[right]>=0) 
            {
                right--;
            }

            if (left<=right) 
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size=scanner.nextInt();
        int[] arr=new int[size];

        System.out.println("Enter the elements:");
        for (int i=0;i<size;i++) 
        {
            arr[i]=scanner.nextInt();
        }

        scanner.close();

        rearrange obj=new rearrange();

        System.out.println("\nOriginal Array:");
        for (int i:arr) 
        {
            System.out.print(i+" ");
        }

        obj.rearrange(arr);

        System.out.println("\nRearranged Array:");
        for (int i:arr) 
        {
            System.out.print(i+" ");
        }
    }
}
