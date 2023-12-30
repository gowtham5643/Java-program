package placement_training;
class MyRunnable implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread Name: " + threadName);
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        t1.start();
        t2.start();
    }
}
