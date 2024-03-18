package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import main.java.MissileLauncher;

public class MissileLauncherTest {

	@Test
	public void testLaunchMissileHit() {
		MissileLauncher ml = new MissileLauncher(1.);
		assertTrue(ml.launchMissile());
	}

	@Test
	public void testLaunchMissileMiss() {
		MissileLauncher ml = new MissileLauncher(0.);
		assertFalse(ml.launchMissile());
	}

}
