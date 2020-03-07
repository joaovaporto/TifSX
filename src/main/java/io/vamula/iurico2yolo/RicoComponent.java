package io.vamula.iurico2yolo;

import java.util.ArrayList;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject;

public class RicoComponent {
	private String type;
	private String label;
	private long[] bounds;

	public RicoComponent(String type, String label, long[] bounds) {
		this.type = type;
		this.label = label;
		this.bounds = bounds;
	}

	public static ArrayList<RicoComponent> getRicoComponents(JSONObject ricoJSON) {
		ArrayList<RicoComponent> ricoComponents = new ArrayList<RicoComponent>();
		getRicoComponentsRecursive(ricoJSON, ricoComponents);
		
		return ricoComponents;
	}
	
	private static void getRicoComponentsRecursive(JSONObject ricoComponent, ArrayList<RicoComponent> ricoComponents) {
		if (ricoComponent.get("componentLabel") != null) {
			String componentLabel = (String) ricoComponent.get("componentLabel");
			String componentType = "general";
			long componentBounds[] = new long[4];
			
			if (componentLabel.equals("Icon")) {
				componentType = componentLabel;
				componentLabel = (String) ricoComponent.get("iconClass");
			} else if (componentLabel.equals("Text Button")) {
				componentType = componentLabel;
				componentLabel = (String) ricoComponent.get("textButtonClass");
			}
			
			JSONArray bounds = (JSONArray) ricoComponent.get("bounds");
			
			for (int i = 0; i < componentBounds.length; i++)
				componentBounds[i] = (long) bounds.get(i);
			
			ricoComponents.add(new RicoComponent(componentType, componentLabel, componentBounds));
		}
		
		if (ricoComponent.get("children") != null) {
			JSONArray ja = (JSONArray) ricoComponent.get("children");
		
			for (Object child : ja)
				getRicoComponentsRecursive((JSONObject) child, ricoComponents);
				
		}
	}

	public String getType() {
		return type;
	}
	
	public String getLabel() {
		return label;
	}

	public long[] getBounds() {
		return bounds;
	}
}
