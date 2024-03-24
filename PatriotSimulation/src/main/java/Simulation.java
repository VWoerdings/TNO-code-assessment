package main.java;

import java.io.File;
import java.io.IOException;

public class Simulation {

	public static void main(String[] args) throws IOException {
		String csvPath = new File("src/main/resources/radar_data.csv").getAbsolutePath();
		RadarEmulator re = new RadarEmulator(csvPath);
		re.readData();
		MissileLauncher ml = new MissileLauncher();

		int time = 0;
		while (re.hasNext()) {
			System.out.printf("Simulation time: %ds\n", time);
			if (IFF.detectFoe(IFF.parseRadarString(re.next()))) {
				System.out.println("Foe detected");
				ml.launchMissile();
			} else {
				System.out.println("No foe detected");
			}
			time++;
			System.out.println();
		}
		System.out.println("Simulation finished");
	}
}
