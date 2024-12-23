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
		float iuYoloWidth = 448;
		float iuYoloHeight = 448;
		float rateConXAxis = (float) 1440/iuYoloWidth;
		float rateConYAxis = (float) 2560/iuYoloHeight;
		float boundsIu448x448[] = new float[4];
		
		boundsIu448x448[0] = ricoComponentBounds[0]/rateConXAxis;
		boundsIu448x448[1] = ricoComponentBounds[1]/rateConYAxis;
		boundsIu448x448[2] = ricoComponentBounds[2]/rateConXAxis;
		boundsIu448x448[3] = ricoComponentBounds[3]/rateConYAxis;
		
		x_center = (((boundsIu448x448[2] - boundsIu448x448[0])/2) + boundsIu448x448[0])/iuYoloWidth;
		y_center = (((boundsIu448x448[3] - boundsIu448x448[1])/2) + boundsIu448x448[1])/iuYoloHeight;
		width = ((float) boundsIu448x448[2] - boundsIu448x448[0])/iuYoloWidth;
		height = ((float) boundsIu448x448[3] - boundsIu448x448[1])/iuYoloHeight;
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
