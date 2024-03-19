package main.java;

import java.util.Random;

public class MissileLauncher {
	private final double PK;
	private final static double DEFAULT_PK = 0.8;
	Random r;

	/**
	 * {@code PK} defaults to {@value #DEFAULT_PK}
	 * 
	 * @see MissileLauncher#MissileLauncher(double)
	 */
	public MissileLauncher() {
		this(DEFAULT_PK);
	}

	/**
	 * Creates MissileLauncher with specific probability of kill
	 * 
	 * @param PK probability of kill ratio, probability of a missile hitting its
	 *           target
	 */
	public MissileLauncher(double PK) {
		this.PK = PK;
		r = new Random();
	}

	/**
	 * Launches missile and checks if it hits its target
	 * 
	 * @return {@code true} if the target was hit; {@code false} otherwise
	 */
	public boolean launchMissile() {
		System.out.println("Launching missile...");
		if (r.nextDouble() > this.PK) {
			System.out.println("Missile missed");
			return false;
		}
		System.out.println("Missile hit");
		return true;

	}
}
