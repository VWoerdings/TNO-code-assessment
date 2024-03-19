package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class RadarEmulator implements Iterator<String> {
	private String data_file;
	private List<String> data;
	private Iterator<String> iterator;

	public RadarEmulator(String data_file) {
		this.data_file = data_file;
	}

	public void readData() throws IOException {
		data = Files.readAllLines(Paths.get(this.data_file));
		iterator = data.iterator();
	}

	@Override
	public boolean hasNext() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("Data has not been initialized");
		}
		return iterator.hasNext();
	}

	@Override
	public String next() {
		return iterator.next();
	}

	public List<String> getData() {
		return data;
	}

}
