package io.vamula.iurico2yolo;

import java.io.FileReader;
import java.util.ArrayList;

public class RicoComponent {
	private String name;
	private int[] bounds;

	public RicoComponent(String name, int[] bounds) {
		this.name = name;
		this.bounds = bounds;
	}

	public static ArrayList<RicoComponent> getRicoComponents(FileReader file) {
		ArrayList<RicoComponent> ricoComponents = new ArrayList<RicoComponent>();

		// TODO
		return ricoComponents;
	}

	public String getName() {
		return name;
	}

	public int[] getBounds() {
		return bounds;
	}
}
