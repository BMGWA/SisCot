package resouces;

public class Calculations {

	public static  String formatDecimal(Double number) {
		Double epsilon = new Double(0.004f); // 4 tenths of a cent
		if (Math.abs(Math.round(number) - number) < epsilon.doubleValue()) {
			return String.format("%10.0f", number); // sdb
		} else {
			return String.format("%10.2f", number); // dj_segfault
		}
	}
}
