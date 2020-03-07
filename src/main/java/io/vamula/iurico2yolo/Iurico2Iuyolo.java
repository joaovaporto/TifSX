package io.vamula.iurico2yolo;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Iurico2Iuyolo {
	public static void main(String args[]) throws IOException {
		if (args.length < 2 || args.length != 3 || !args[0].equals("-s")) {
			System.out.println("For just one file conv: iurico2iuyolo <file-iurico-address> <file-iuyolo-address>");
			System.out.println("For several files conv: iurico2iuyolo -s <folder-iurico-address> <folder-iuyolo-address>");
			System.exit(0);
		}
		
		try {
			if (args.length == 3) {
				
			} else {
				iurico2iuyolo(args[0], args[1]);
			}
			
			System.out.println("Awesome! Everything is ready.");
		} catch (Exception e) {
			System.err.println("Conversion failed. Something seems be wrong:");
			System.err.println(e.getMessage());
		}
	}
	
	public static void iurico2iuyolo(String addrRicoFile, String addrYoloFile) throws IOException, ParseException {
		RicoFile ricoFile = new RicoFile(addrRicoFile);
		YoloFile yoloFile = new YoloFile(ricoFile);

		yoloFile.writeFile(addrYoloFile);
	}
}
