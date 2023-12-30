package placement_training;
class PrimeNumberFinder implements Runnable {
    private int start;
    private int end;

    public PrimeNumberFinder(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        System.out.print("Prime numbers from " + start + " to " + end + " : ");
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeNumberFinder implements Runnable {
    private int start;
    private int end;

    public PalindromeNumberFinder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.print("Palindrome numbers from " + start + " to " + end + " : ");
        for (int i = start; i <= end; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private boolean isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;
        while (num > 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return originalNum == reversedNum;
    }
}

public class ThreadSample {
    public static void main(String[] args) {
        Thread primeThread = new Thread(new PrimeNumberFinder(0, 10));
        Thread palindromeThread = new Thread(new PalindromeNumberFinder(10, 50));

        primeThread.start();
        try {
            primeThread.join(); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        palindromeThread.start();
    }
}
