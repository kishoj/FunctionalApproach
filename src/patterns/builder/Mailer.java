package patterns.builder;

import java.util.function.Consumer;

public class Mailer {
	private String from;
	private String to;
	private String subject;
	private String body;
	private boolean isSent = false;

	public static void print(String msg) {
		System.out.println(msg);
	}

	public Mailer from(String iFrom) {
		this.from = iFrom;
		print(iFrom);
		return this;
	}

	public Mailer to(String iTo) {
		this.to = iTo;
		print(iTo);
		return this;
	}

	public Mailer subject(String iSubject) {
		this.subject = iSubject;
		print(iSubject);
		return this;
	}

	public Mailer body(String iBody) {
		this.body = iBody;
		print(iBody);
		return this;
	}

	public Mailer send() {
		print("Sending....");
		return this;
	}

	public static Mailer send(Consumer<Mailer> block) {
		Mailer mailer = new Mailer();
		block.accept(mailer);
		print("Sending....");
		mailer.isSent = true;
		return mailer;
	}

	@Override
	public String toString() {
		return "Mailer [from=" + from + ", to=" + to + ", subject=" + subject + ", body=" + body + ", isSent=" + isSent
				+ "]";
	}
}
