package patterns.functional.inteface;

@FunctionalInterface
public interface Operator<T> {
	T apply(T x, T y);
}
