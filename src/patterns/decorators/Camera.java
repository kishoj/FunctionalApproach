package patterns.decorators;

import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class Camera {
	private Function<Color, Color> filter;
	
	public Camera(Function<Color, Color>... filters) {
		setFilters(filters);
	}

	public void setFilters(Function<Color, Color>... filters) {
		filter = Stream.of(filters).reduce(Function.identity(), Function::andThen);
	}

	public Color snap(Color input) {
		return filter.apply(input);
	}
}
