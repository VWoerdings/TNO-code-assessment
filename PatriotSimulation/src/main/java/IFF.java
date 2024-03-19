package main.java;

public class IFF {

	/**
	 * {@code validate} defaults to <code>false</code>
	 * 
	 * @see IFF#parseRadarString(String, boolean)
	 */
	public static String[] parseRadarString(String radarString) throws IllegalArgumentException {
		return parseRadarString(radarString, false);
	}

	/**
	 * Splits one line of radar output into an array of binary numbers
	 * 
	 * @param radarString one line of radar output, separated by a semicolon
	 * @param validate    if {@code true}, checks if {@code radarString} contains
	 *                    unexpected values
	 * @return array of binary numbers
	 * @throws IllegalArgumentException if radar output contains unexpected values
	 */
	public static String[] parseRadarString(String radarString, boolean validate) throws IllegalArgumentException {
		String[] radarData = radarString.split(";");
		if (!validate || isBinary(radarData)) {
			return radarData;
		}
		throw new IllegalArgumentException("Invalid radar output");
	}

	/**
	 * Detects foe, based on processed radar output
	 * 
	 * @param radarData array of binary numbers
	 * @return {@code true} if {@code radarData} contains more uneven numbers than
	 *         even numbers; {@code false} otherwise
	 */
	public static boolean detectFoe(String[] radarData) {
		int nNums = radarData.length;
		int nOdd = 0;
		for (int i = 0; i < nNums; i++) {
			if (radarData[i].endsWith("1")) {
				nOdd++;
			}
		}
		return nOdd > nNums / 2;
	}

	/**
	 * Checks if each string in the input array is binary
	 * 
	 * @see #isBinary(String)
	 */
	public static boolean isBinary(String[] input) {
		for (String s : input) {
			if (!isBinary(s)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if input string is binary
	 * 
	 * @param input string to check
	 * @return {@code true} if {@code input} only contains 0s and 1s; {@code false}
	 *         otherwise
	 */
	public static boolean isBinary(String input) {
		return input.replaceAll("0|1", "").length() == 0;
	}
}
