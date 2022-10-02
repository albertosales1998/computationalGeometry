package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readPoints(args);
	}
	
	public static void readPoints(String[] args) {
		try {
			File pointsFile = new File(args[0]);
			Scanner scanner = new Scanner(pointsFile);
			
			List<String> shapeInfoStrings = new ArrayList<String>();
			
			while(scanner.hasNextLine()) {
				shapeInfoStrings.add(scanner.nextLine());
			}
			
			int numVertices = Integer.parseInt(shapeInfoStrings.get(0));
			shapeInfoStrings.remove(0);
			
			List<Integer[]> coordinates = new ArrayList<Integer[]>();
			for(String s : shapeInfoStrings) {
				String[] numbers = s.split(" ");
				coordinates.add(new Integer[] {Integer.valueOf(numbers[0]), Integer.valueOf(numbers[1])});
			}
			
			System.out.println("Number of Vertices: " + numVertices);
			for(Integer[] i : coordinates) {
				System.out.println("Cooridinates: (" + i[0] + ", " + i[1] + ")");
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("Error parsing file, perhaps you mistyped it, or it is in the wrong location.");
		}
	}
}
