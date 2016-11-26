package patterns.annotations;

public class MainApp {
	public static void main(String[] args) throws Exception {
		TestAnnotationParser parser = new TestAnnotationParser();
		parser.parse(Annotated.class);
	}

}
