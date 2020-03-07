package io.vamula.iurico2yolo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

public class RicoComponent {
	private String type;
	private String label;
	private int[] bounds;

	public RicoComponent(String type, String label, int[] bounds) {
		this.type = type;
		this.label = label;
		this.bounds = bounds;
	}

	public static ArrayList<RicoComponent> getRicoComponents(JSONObject jo) {
		ArrayList<RicoComponent> ricoComponents = new ArrayList<RicoComponent>();

//		int bounds[] = {100, 100, 200, 200};
//		ricoComponents.add(new RicoComponent("general", "Image", bounds));
//		ricoComponents.add(new RicoComponent("icon", "retry", bounds));
//		ricoComponents.add(new RicoComponent("text-button", "volume", bounds));
		
		getRicoComponentsRecursive(jo, ricoComponents);		
		return ricoComponents;
	}
	
	private static void getRicoComponentsRecursive(JSONObject jo, ArrayList<RicoComponent> ricoComponents) {
		if (jo.get("componentLabel") != null) {
			String componentLabel = (String) jo.get("componentLabel");
			String type = "general";
			int bounds[] = new int[4];
			
			if (componentLabel.equals("Icon")) {
				type = componentLabel;
				componentLabel = (String) jo.get("iconClass");
			} else if (componentLabel.equals("Text Button")) {
				type = componentLabel;
				componentLabel = (String) jo.get("textButtonClass");
			}
			
			JSONArray ja = (JSONArray) jo.get("bounds");
			Iterator<?> itr = ja.iterator();
			
			for (int i = 0; i < bounds.length; i++)
				bounds[i] = (int) itr.next();
			
			ricoComponents.add(new RicoComponent(type, componentLabel, bounds));
		}
		
		if (jo.get("children") != null) {
			JSONArray ja = (JSONArray) jo.get("bounds");
			Iterator<?> itr = ja.iterator();
			
			while(itr.hasNext()) {
				Map.Entry pair = itr.next();
				getRicoComponentsRecursive((JSONObject) pair.getValue(), ricoComponents);
			}
				
		}
	}

	public String getType() {
		return type;
	}
	
	public String getLabel() {
		return label;
	}

	public int[] getBounds() {
		return bounds;
	}
}
