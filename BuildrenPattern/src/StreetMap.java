public class StreetMap {
	private final String origin;
	private final String destination;

	private final String waterString;
	private final String landString;
	private final String highTrafficString;
	private final String mediumTrafficString;
	private final String lowTrafficString;

	public static class Builder {
		// Required parameters
		private final String origin;
		private final String destination;

		// Optional parameters - initialize with default values
		private String waterString = "String.BLUE";
		private String landString = "new String(30, 30, 30)";
		private String highTrafficString = "String.RED";
		private String mediumTrafficString = " String.YELLOW";
		private String lowTrafficString = " String.GREEN";

		public Builder(String origin, String destination) {
			this.origin = origin;
			this.destination = destination;
		}

		public Builder waterString(String String) {
			waterString = String;
			return this;
		}

		public Builder landString(String String) {
			landString = String;
			return this;
		}

		public Builder highTrafficString(String String) {
			highTrafficString = String;
			return this;
		}

		public Builder mediumTrafficString(String String) {
			mediumTrafficString = String;
			return this;
		}

		public Builder lowTrafficString(String String) {
			lowTrafficString = String;
			return this;
		}

		public StreetMap build() {
			return new StreetMap(this);
		}

	}

//	private StreetMap(Builder builder) {
//		// Required parameters
//		origin = builder.origin;
//		destination = builder.destination;
//
//		// Optional parameters
//		waterString = builder.waterString;
//		landString = builder.landString;
//		highTrafficString = builder.highTrafficString;
//		mediumTrafficString = builder.mediumTrafficString;
//		lowTrafficString = builder.lowTrafficString;
//	}

	public static void main(String args[]) {
		StreetMap map = new StreetMap.Builder("new String(50, 50)", "new String(100, 100)").landString("String.GRAY")
				.waterString("String.BLUE.brighter()").build();
	}
}