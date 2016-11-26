package patterns.decorators;

import java.awt.Color;

public class MainApp {
	public static void printSnap(Camera camera) {
		System.out.println(camera.snap(new Color(125, 125, 125)));
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Decorating using lambda expression
		printSnap(new Camera());
		printSnap(new Camera(Color::brighter));
		printSnap(new Camera(Color::darker));
		printSnap(new Camera(Color::brighter, Color::darker));
		printSnap(new Camera(Color::brighter, Color::darker, Color::darker));
	}

}
