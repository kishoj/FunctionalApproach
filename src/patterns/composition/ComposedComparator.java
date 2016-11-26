package patterns.composition;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class ComposedComparator<T> implements Comparator<T> {
	private Comparator<T>[] comparators;

	public ComposedComparator(Comparator<T>... comparators) {
		this.comparators = comparators;
	}

	@Override
	public int compare(T o1, T o2) {
		int result = 0;
		for (Comparator<T> comparator : comparators) {
			result = comparator.compare(o1 , o2);
			if (result != 0) {
				return result;
			}
		}
		return result;
	}
}