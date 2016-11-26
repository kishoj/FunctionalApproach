package patterns.resources;

public class MainApp {

	public static void main(String[] args) {
		Resource.use(resource -> {
			resource.operation1()
					.operation2()
					.operation3()
					.operation4();
		});
	}
	
}
