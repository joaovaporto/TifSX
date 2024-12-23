package io.vamula.iurico2yolo;

public class YoloComponent {
	private int labelId;
	private float x_center; // Is the X coordinate of the centre of the object that has to be detected/Image_width
	private float y_center; // Is the Y coordinate of the centre of the object that has to be detected/Image_height
	private float width; // Is the width of the object that has to be detected/Image_width
	private float height; // Is the height of the object that has to be detected/Image_height

	public YoloComponent(RicoComponent ricoComponent) {
		rico2yoloComponent(ricoComponent);
	}

	private void rico2yoloComponent(RicoComponent ricoComponent) {
		this.labelId = YoloIdIdentifier.getId(ricoComponent);
		rico2yoloComponentBounds(ricoComponent.getBounds());	
	}

	private void rico2yoloComponentBounds(long[] ricoComponentBounds) {
		float ricoWidth = 1440;
		float ricoHeight = 2560;

		// converts to yolo format
		x_center = (((ricoComponentBounds[2] - ricoComponentBounds[0])/2) + ricoComponentBounds[0])/ricoWidth;
		y_center = (((ricoComponentBounds[3] - ricoComponentBounds[1])/2) + ricoComponentBounds[1])/ricoHeight;
		width = ((float) ricoComponentBounds[2] - ricoComponentBounds[0])/ricoWidth;
		height = ((float) ricoComponentBounds[3] - ricoComponentBounds[1])/ricoHeight;
	}
	
	public int getLabelId() {
		return labelId;
	}
	
	public float getX_center() {
		return x_center;
	}

	public float getY_center() {
		return y_center;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}
}
