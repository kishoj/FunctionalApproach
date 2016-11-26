package patterns.builder;

public class MainApp {

	public static void main(String[] args) {
		Mailer mailer = new Mailer().from("kishoj@gmail.com").to("kishoj.hotmail.com").subject("Hello world test")
				.body("this is mail body").send();
		
		System.out.println(mailer.toString());
		System.out.println();

		Mailer mailerreturned = Mailer.send(mailer2 -> {
			mailer2.from("kishoj@gmail.com").to("kishoj.hotmail.com").subject("Hello world test")
					.body("this is mail body");
		});

		System.out.println(mailerreturned.toString());
		System.out.println();
	}

}
