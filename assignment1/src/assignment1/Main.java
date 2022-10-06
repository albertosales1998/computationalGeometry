package assignment1;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Algorithms utility = new Algorithms(readPoints(args));
		//utility.printPointsAndAmount();
		GeometricObject polygon = utility.polygonType();
		polygon.setBoundaryColor(Color.BLUE);
		polygon.setInteriorColor(Color.MAGENTA);
		System.out.println(polygon.toString());
		FrameDisplay frame = new FrameDisplay(polygon);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static List<Integer[]> readPoints(String[] args) {
		try {
			File pointsFile = new File(args[0]);
			Scanner scanner = new Scanner(pointsFile);
			
			List<String> shapeInfoStrings = new ArrayList<String>();
			
			while(scanner.hasNextLine()) {
				shapeInfoStrings.add(scanner.nextLine());
			}
			
			try {
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
				return coordinates;
				
			} catch(Exception e) {
				System.out.println("Ensure there are no white spaces following the number of points in your text file.");
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("Error parsing file, perhaps you mistyped it, or it is in the wrong location.");
		}
		return null;
	}
}
