package using.lambdas;

interface Executable {
	void execute();
}

interface ExecutableAndRetunnable {
	int executeAndReturn();
}

interface Runnable {
	void run(Executable e);
}

class Runner implements Runnable {

	@Override
	public void run(Executable e) {
		System.out.println("Executing code block");
		e.execute();		
	}
	
}

class Returnable {
	public void runAndExecute(ExecutableAndRetunnable e) {
		int value = e.executeAndReturn();
		System.out.println("Return value " + value);
	}
	
}

public class App {
	public static void main(String[] args) {
		Runner runner = new Runner();
		runner.run(new Executable() {

			@Override
			public void execute() {
				System.out.println("Old way");
			}
			
		});
		runner.run(() -> {
			System.out.println("Block in lambda expression");
		});

		Returnable runner2 = new Returnable();
		runner2.runAndExecute(() -> {
			System.out.println("Block in lambda expression");
			return 9;
		});
	}
}
