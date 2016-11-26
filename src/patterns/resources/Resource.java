package patterns.resources;

import java.util.function.Consumer;

public class Resource {
	private Resource() {
		System.out.println("Resource Created...");
	}
	
	public Resource operation1() {
		System.out.println("Operation 1");
		return this;
	}
	
	public Resource operation2() {
		System.out.println("Operation 2");
		return this;
	}
	
	public Resource operation3() {
		System.out.println("Operation 3");
		return this;
	}
	
	public Resource operation4() {
		System.out.println("Operation 4");
		return this;
	}
	
	private void close() {
		System.out.println("Clean Up");
	}
	
	public static void use(Consumer<Resource> block) {
		Resource resource = new Resource();
		try {
			 block.accept(resource);
		} finally {
			resource.close();
		}
	}
}
