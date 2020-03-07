package io.vamula.iurico2yolo;

import java.io.FileReader;
import java.util.ArrayList;

public class RicoComponent {
	private String type;
	private String label;
	private int[] bounds;

	public RicoComponent(String type, String label, int[] bounds) {
		this.type = type;
		this.label = label;
		this.bounds = bounds;
	}

	public static ArrayList<RicoComponent> getRicoComponents(FileReader file) {
		ArrayList<RicoComponent> ricoComponents = new ArrayList<RicoComponent>();

//		int bounds[] = {100, 100, 200, 200};
//		ricoComponents.add(new RicoComponent("general", "Image", bounds));
//		ricoComponents.add(new RicoComponent("icon", "retry", bounds));
//		ricoComponents.add(new RicoComponent("text-button", "volume", bounds));
		
		return ricoComponents;
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
