package patterns.cake;

//http://stackoverflow.com/questions/14248766/cake-pattern-with-java8-possible

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalApp localApp = new LocalApp();
		System.out.println(localApp.getUserService().authenticate("kishoj", "pass"));
		
		MongoApp mongoApp = new MongoApp();
		System.out.println(mongoApp.getUserService().authenticate("kishoj", "pass"));
	}

}
