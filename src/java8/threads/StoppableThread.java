package java8.threads;

public class StoppableThread implements Runnable {
    private volatile boolean execute;
    
    private int i = 0;

    @Override
    public void run() {
        this.execute = true;
        while (this.execute) {
            try {
                System.out.println("Sleeping...");
                Thread.sleep((long) 3000);
                System.out.println("Processing");
                Thread.sleep((long) 2000);
                if (i == 2) stopExecuting();
                i++;
            } catch (InterruptedException e) {
                this.execute = false;
            }
        }
        System.out.println("Thread stopped");
    }

    public void stopExecuting() {
        this.execute = false;
    }
}
