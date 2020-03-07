package io.vamula.iurico2yolo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RicoFile {
	private ArrayList<RicoComponent> ricoComponents;

	public RicoFile(String addrFile) throws IOException {
		FileReader file = new FileReader(addrFile);
		ricoComponents = RicoComponent.getRicoComponents(file);
		
		file.close();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<RicoComponent> getRicoComponents() {
		return (ArrayList<RicoComponent>) ricoComponents.clone();
	}
}
