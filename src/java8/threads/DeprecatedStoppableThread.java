package java8.threads;

public class DeprecatedStoppableThread implements Runnable {
	private int i = 0;

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				System.out.println("Sleeping...");
				Thread.sleep((long) 3000);
				System.out.println("Processing");
				Thread.sleep((long) 2000);
				if (i == 2)
					stopExecuting();
				i++;
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		System.out.println("Thread stopped");
	}

	@SuppressWarnings("deprecation")
	public void stopExecuting() {
	    Thread.currentThread().stop();
	}
}
