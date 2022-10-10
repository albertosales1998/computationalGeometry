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
		Triangle[] triangles = getInnerTriangles();
		for(Triangle t : triangles) System.out.println(t.toString());
		
		for(Triangle t : triangles) {
			if(pythagoreanTheoremEquality(t.getSideLength(0), t.getSideLength(1), t.getSideLength(2)) != true || t.getSideLength(0) == t.getSideLength(1)) { // test if right triangle does not exist or if two perpendicular sides are equal (i.e. a square)
				System.out.println("False!");
				System.out.println(Math.pow(t.getSideLength(0), 2) + Math.pow(t.getSideLength(1), 2) + " " + Math.pow(t.getSideLength(2), 2));
				return new Quadrilateral(points);
			}
		}
		System.out.println("True!");
		return new Rectangle(points.get(0), points.get(2));
	}
	
	public Triangle[] getInnerTriangles() { //have to change change hardcode to dynamic for rectilinear polygons for any 'n' vertices
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
	
	public boolean pythagoreanTheoremEquality(double side0, double side1, double side2) {
		return Math.round(Math.pow(side0, 2) + Math.pow(side1, 2)) == Math.round(Math.pow(side2, 2));
	}
}
