package patterns.functional.inteface;

public enum SimpleOperation implements Operator<Double> {
	PLUS("+") {
		@Override
		public Double apply(Double x, Double y) {
			return x + y;
		}
	},
	MINUS("-") {
		@Override
		public Double apply(Double x, Double y) {
			return x - y;
		}
	},
	MULTIPLY("*") {
		@Override
		public Double apply(Double x, Double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		@Override
		public Double apply(Double x, Double y) {
			return x / y;
		}
	};

	private final String symbol;

	SimpleOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
}
