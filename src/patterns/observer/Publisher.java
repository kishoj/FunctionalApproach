package patterns.observer;

import java.util.HashSet;
import java.util.Set;

public abstract class Publisher {
	Set<Subscriber> subscribers = new HashSet<Subscriber>();

	protected void subscribe(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	protected void unsubscribe(Subscriber subscriber) {
		subscribers.remove(subscribers);
	}

	protected void publish() {
		subscribers.forEach(subscriber -> subscriber.handler(this));
	}
}
