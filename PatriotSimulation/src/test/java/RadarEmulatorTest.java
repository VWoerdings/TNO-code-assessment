package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.RadarEmulator;

public class RadarEmulatorTest {

	@Test
	void testReadDataException() {
		RadarEmulator rs = new RadarEmulator("file/does/not/exist");

		assertThrows(IOException.class, () -> {
			rs.readData();
		});
	}

	@Test
	void testReadData() throws IOException {
		RadarEmulator rs = new RadarEmulator("src/test/resources/test_input.csv");
		rs.readData();
		assertEquals(rs.getData(), Arrays.asList("0001010", "0111000", "1101001"));
	}

	@Test
	void testHasNext() {
		RadarEmulator rs = new RadarEmulator("src/test/resources/test_input.csv");
		assertThrows(NullPointerException.class, () -> {
			rs.hasNext();
		});
	}
}
