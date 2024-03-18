package main.java;

import java.util.Random;

public class MissileLauncher {
	private final double PK;
	Random r;

	public MissileLauncher() {
		this(0.8);
	}

	public MissileLauncher(double PK) {
		this.PK = PK;
		r = new Random();
	}

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
