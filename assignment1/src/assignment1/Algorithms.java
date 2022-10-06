package assignment1;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {
	
	private ArrayList<Point> points;
	private int numVertices;
	
	public Algorithms(List<Integer[]> coordinates) {
		points = convertToPoints(coordinates);
		this.numVertices = coordinates.size();
	}
	
	public ArrayList<Point> convertToPoints(List<Integer[]> coordinates){
		ArrayList<Point> points = new ArrayList<>();
		
		for(Integer[] o : coordinates) {
			points.add(new Point(o[0], o[1]));
		}
		return points;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	
	public void printPointsAndAmount() {
		for(Point p : points) System.out.println(p.toString());
		System.out.println("Number of Vertices: " + this.numVertices);
	}
	
	public GeometricObject polygonType() {
		switch(numVertices) {
		case 3: return new Triangle(points);
		}
return null;
	}
	
	public String determineQuadrilateral() {
		
		return "";
	}
}
