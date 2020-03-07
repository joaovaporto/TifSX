package io.vamula.iurico2yolo;

public class YoloComponent {
	private int id;
	private int[] coordinates;

	public YoloComponent(RicoComponent ricoComponent) {
		coordinates = new int[4];
		rico2yoloComponent(ricoComponent);
	}
	
	public int getId() {
		return id;
	}
	
	public int[] getCoordinates() {
		return coordinates;
	}

	private void rico2yoloComponent(RicoComponent ricoComponent) {
//		id = rico2yoloComponentName(ricoComponent.getName()); // TODO
		id = 0;
		rico2yoloComponentBounds(ricoComponent.getBounds());	
	}

	private void rico2yoloComponentBounds(int[] ricoComponentBounds) {
		// TODO
		coordinates[1] = ricoComponentBounds[1];
		coordinates[2] = ricoComponentBounds[2];
		coordinates[3] = ricoComponentBounds[3];
		coordinates[4] = ricoComponentBounds[4];
	}
}
