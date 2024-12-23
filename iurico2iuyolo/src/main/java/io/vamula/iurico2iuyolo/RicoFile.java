package io.vamula.iurico2yolo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RicoFile {
	private ArrayList<RicoComponent> ricoComponents;

	public RicoFile(String addrFile) throws IOException, ParseException {
		FileReader file = new FileReader(addrFile);
		JSONObject ricoJSON = (JSONObject) new JSONParser().parse(file);
		
		ricoComponents = RicoComponent.getRicoComponents(ricoJSON);
		
		file.close();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<RicoComponent> getRicoComponents() {
		return (ArrayList<RicoComponent>) ricoComponents.clone();
	}
}
