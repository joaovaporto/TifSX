package io.vamula.iurico2yolo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class YoloFile {
	private ArrayList<YoloComponent> yoloComponents;

	public YoloFile(RicoFile ricoFile) {
		yoloComponents = new ArrayList<YoloComponent>();
		rico2yoloFile(ricoFile);
	}

	private void rico2yoloFile(RicoFile ricoFile) {
		for (RicoComponent ricoComponent : ricoFile.getRicoComponents())
			yoloComponents.add(new YoloComponent(ricoComponent));
	}

	public void writeFile(String fileAddr) throws IOException {
		FileWriter file = new FileWriter(fileAddr);
		
		file.close();
		// TODO
	}
}
