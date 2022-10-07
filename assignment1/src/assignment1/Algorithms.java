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
		case 4: return determineQuadrilateral();
		}
		return null;
	}
	
	public GeometricObject determineQuadrilateral() {
		Triangle[] triangles = getInnerTriangles(); //have triangles array, need to calculate the midpoint angle of each triangle using law of cosines
		
		return null;
	}
	
	public Triangle[] getInnerTriangles() {
		ArrayList<Point> triangleP0P2 = new ArrayList<Point>(List.of(points.get(0), points.get(1), points.get(2)));
		ArrayList<Point> triangleP1P3 = new ArrayList<Point>(List.of(points.get(1), points.get(2), points.get(3)));
		ArrayList<Point> triangleP2P0 = new ArrayList<Point>(List.of(points.get(2), points.get(3), points.get(0)));
		ArrayList<Point> triangleP3P1 = new ArrayList<Point>(List.of(points.get(3), points.get(0), points.get(1)));
		
		return new Triangle[] {
				new Triangle(triangleP0P2),
				new Triangle(triangleP1P3),
				new Triangle(triangleP2P0),
				new Triangle(triangleP3P1)
		};
	}
}
