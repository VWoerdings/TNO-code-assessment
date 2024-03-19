package main.java;

import java.io.File;
import java.io.IOException;

public class Simulation {

	public static void main(String[] args) throws IOException {
		String csvPath = new File("src/main/resources/radar_data.csv").getAbsolutePath();
		RadarEmulator rs = new RadarEmulator(csvPath);
		rs.readData();
		MissileLauncher ml = new MissileLauncher();

		int time = 0;
		while (rs.hasNext()) {
			System.out.printf("Simulation time: %ds\n", time);
			if (IFF.detectFoe(IFF.parseRadarString(rs.next()))) {
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
