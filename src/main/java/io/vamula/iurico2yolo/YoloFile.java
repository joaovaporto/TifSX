package io.vamula.iurico2yolo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
		File file = new File(fileAddr);
		FileOutputStream fos = new FileOutputStream(file);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		for (YoloComponent yoloComponent : yoloComponents) {
			bw.write(yoloComponent.getLabelId() +
					" " + yoloComponent.getX_center() +
					" " + yoloComponent.getY_center() +
					" " + yoloComponent.getHeight() +
					" " + yoloComponent.getHeight());
			
			bw.newLine();
		}
		
		bw.close();
	}
}
