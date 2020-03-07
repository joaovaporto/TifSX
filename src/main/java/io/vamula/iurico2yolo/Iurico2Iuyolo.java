package io.vamula.iurico2yolo;

import java.io.IOException;

public class Iurico2Iuyolo {
	public static void main(String args[]) throws IOException {
		if (args.length != 2) {
			System.out.println("Usage: iurico2iuyolo <file-iurico-address> <file-iuyolo-address>");
			System.exit(0);
		}
		
		try {
			RicoFile ricoFile = new RicoFile(args[0]);
			YoloFile yoloFile = new YoloFile(ricoFile);

			yoloFile.writeFile(args[1]);
			System.out.println("Awesome! Everything is ready.");
		} catch (Exception e) {
			System.err.println("Something seems be wrong, check the stack:");
			System.err.println(e.getMessage());
		}
	}
}
