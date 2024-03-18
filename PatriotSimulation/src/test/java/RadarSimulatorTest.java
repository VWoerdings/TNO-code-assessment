package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import main.java.RadarSimulator;

public class RadarSimulatorTest {

	@Test
	void testReadDataException() {
		RadarSimulator rs = new RadarSimulator("file/does/not/exist");

		assertThrows(IOException.class, () -> {
			rs.readData();
		});
	}

	@Test
	void testReadData() throws IOException {
		RadarSimulator rs = new RadarSimulator("src/test/resources/test_input.csv");
		rs.readData();
		assertEquals(rs.getData(), Arrays.asList("0001010", "0111000", "1101001"));
	}

	@Test
	void testHasNext() {
		RadarSimulator rs = new RadarSimulator("src/test/resources/test_input.csv");
		assertThrows(NullPointerException.class, () -> {
			rs.hasNext();
		});

	}

}
