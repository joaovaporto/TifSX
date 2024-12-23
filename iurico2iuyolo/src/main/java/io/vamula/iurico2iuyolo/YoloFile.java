package io.vamula.iurico2yolo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

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
		
		DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols(Locale.getDefault());
		formatSymbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.000000", formatSymbols);
		
		for (YoloComponent yoloComponent : yoloComponents) {
			bw.write(yoloComponent.getLabelId() +
					" " + df.format(yoloComponent.getX_center()) +
					" " + df.format(yoloComponent.getY_center()) +
					" " + df.format(yoloComponent.getWidth()) +
					" " + df.format(yoloComponent.getHeight()));
			
			bw.newLine();
		}
		
		bw.close();
	}
}
