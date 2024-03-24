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
		RadarEmulator re = new RadarEmulator("file/does/not/exist");

		assertThrows(IOException.class, () -> {
			re.readData();
		});
	}

	@Test
	void testReadData() throws IOException {
		RadarEmulator re = new RadarEmulator("src/test/resources/test_input.csv");
		re.readData();
		assertEquals(re.getData(), Arrays.asList("0001010", "0111000", "1101001"));
	}

	@Test
	void testHasNext() {
		RadarEmulator re = new RadarEmulator("src/test/resources/test_input.csv");
		assertThrows(NullPointerException.class, () -> {
			re.hasNext();
		});
	}
}
