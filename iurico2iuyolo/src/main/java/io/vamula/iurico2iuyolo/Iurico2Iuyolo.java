package io.vamula.iurico2yolo;

import java.io.File;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Iurico2Iuyolo {
	public static void main(String args[]) throws IOException, ParseException {
		if (args.length != 2 && (args.length != 3 || !args[0].equals("-s"))) {
			System.out.println("For just one file conv: iurico2iuyolo <file-iurico-address> <file-iuyolo-address>");
			System.out.println("For several files conv: iurico2iuyolo -s <dir-iurico-address> <dir-iuyolo-address>");
			System.exit(0);
		}
		
		try {	
			if (args.length == 2) {
				iurico2iuyolo(args[0], args[1]);
			} else {
				File ricoDir = new File(args[1]);
				File[] ricoFiles = ricoDir.listFiles();
				if (ricoFiles == null) throw new RuntimeException("Dir iurico is empty or actually is not a dir.");
				
				for (File ricoFile : ricoFiles) {
					String addrRicoFile = ricoFile.getAbsolutePath();
					
					if (!addrRicoFile.contains(".json")) continue;
					
					String addrYoloFile = addrRicoFile.substring(addrRicoFile.lastIndexOf(File.separator),
							addrRicoFile.lastIndexOf(".json"));
					addrYoloFile = args[2] + File.separator + addrYoloFile + ".txt";
					
					try {
						iurico2iuyolo(addrRicoFile, addrYoloFile);
					} catch (Exception e) {
						System.err.println("Conversion failed for file \'" + addrRicoFile + "\':");
						System.err.println(e.getMessage());
					}
				}				
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
