package assignment1;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filepath = JOptionPane.showInputDialog("Please enter filename. " +
				"If it does not work, try using the absolute file path.");

		Algorithms utility = new Algorithms(readPoints(filepath));
		GeometricObject polygon = utility.polygonType();
		polygon.setBoundaryColor(Color.BLUE);
		polygon.setInteriorColor(Color.MAGENTA);
		FrameDisplay frame = new FrameDisplay(polygon);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, polygon.getShapeName());
	}
	
	public static List<Integer[]> readPoints(String filepath) {
		try {
			File pointsFile = new File(filepath);
			Scanner scanner = new Scanner(pointsFile);
			List<String> shapeInfoStrings = new ArrayList<>();

			while(scanner.hasNextLine()) shapeInfoStrings.add(scanner.nextLine());
			
			try {
				shapeInfoStrings.remove(0);
				List<Integer[]> coordinates = new ArrayList<>();
				for(String s : shapeInfoStrings) {
					String[] numbers = s.split(" ");
					coordinates.add(new Integer[] {Integer.valueOf(numbers[0]), Integer.valueOf(numbers[1])});
				}
				return coordinates;
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null,
						"Error parsing file, please look over your points file for correct format.");
			}
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"Error finding file, perhaps you mistyped it, or it is in the wrong location. Ensure" +
							" the absolute file path is being used.");
		}
		return null;
	}
}
