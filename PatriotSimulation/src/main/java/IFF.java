package main.java;

public class IFF {

	public static String[] parseRadarString(String radarString) throws IllegalArgumentException {
		return parseRadarString(radarString, false);
	}

	public static String[] parseRadarString(String radarString, boolean validate) throws IllegalArgumentException {
		String[] radarData = radarString.split(";");
		if (!validate || isBinary(radarData)) {
			return radarData;
		}
		throw new IllegalArgumentException("Invalid radar output");
	}

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

	public static boolean isBinary(String[] input) {
		for (String s : input) {
			if (!isBinary(s)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isBinary(String input) {
		return input.replaceAll("0|1", "").length() == 0;
	}
}
