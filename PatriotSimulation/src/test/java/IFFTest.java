package test.java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.java.IFF;

public class IFFTest {

	@Test
	public void testParseRadarString() {
		String[] out = IFF.parseRadarString("0001010;0110011;11", true);
		String[] expected = { "0001010", "0110011", "11" };
		assertArrayEquals(out, expected);
	}

	@Test
	public void testParseRadarStringValidate() {
		assertThrows(IllegalArgumentException.class, () -> {
			IFF.parseRadarString("0001010;9110011;11", true);
		});

	}

	@ParameterizedTest
	@ValueSource(strings = { "0001010;0110011;0100110;0010000;0011100;0101101;1111010;1011101;0110100;11",
			"0111000;1101001;0011101;1000010;1010000;0011010;0110000;0010111;0101001;10" })
	public void testDetectFoeFalse(String input) {
		assertFalse(IFF.detectFoe(IFF.parseRadarString(input)));
	}

	@ParameterizedTest
	@ValueSource(strings = { "0110100;1011111;0101101;1010111;1101011;0010001;1011111;1111010;0100100;10",
			"0100100;1111111;1100010;0111001;0111000;1010011;1100001;0010111;0111001;10" })
	public void testDetectFoeTrue(String input) {
		assertTrue(IFF.detectFoe(IFF.parseRadarString(input)));
	}

	@Test
	public void testIsBinary() {
		assertTrue(IFF.isBinary("0110100"));
		assertTrue(IFF.isBinary(IFF.parseRadarString("0001010;0110011;11")));
		assertFalse(IFF.isBinary("12345"));
		assertFalse(IFF.isBinary(IFF.parseRadarString("0001010;9110011;11")));
	}

}
