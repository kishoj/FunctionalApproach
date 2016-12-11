package java8.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaLatestThreads {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(new DeprecatedStoppableThread());
		executor.execute(new AnotherStoppableThread());
		executor.execute(new StoppableThread());
		executor.shutdown();
	}
}
