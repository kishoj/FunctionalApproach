package patterns.functional.inteface;

public enum ExtendedOperation implements Operator<Double> {
	EXP("^") {
		@Override
		public Double apply(Double x, Double y) {
			return Math.pow(x, y);
		}
	},
	REMAINDER("%") {
		@Override
		public Double apply(Double x, Double y) {
			return x % y;
		}
	};

	private final String symbol;

	ExtendedOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
}
