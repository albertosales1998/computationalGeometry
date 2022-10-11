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
		default: return determinePolygon();
		}
	}
	
	public GeometricObject determinePolygon() {
		Triangle[] triangles = getInnerTriangles();
		for(Triangle t : triangles) System.out.println(t.toString());
		
		for(Triangle t : triangles) {
			if(pythagoreanTheoremEquality(t.getSideLength(0), t.getSideLength(1), t.getSideLength(2)) != true) { // if right triangle does not exist, than move onto the convex case
				System.out.println("Not a rectilinear polygon");
				System.out.println(Math.pow(t.getSideLength(0), 2) + Math.pow(t.getSideLength(1), 2) + " " + Math.pow(t.getSideLength(2), 2));
				// determineIfConvex(); <---- LEFT OFF HERE; need to implement this method to return a convex or simple polygon
			}
		}
		System.out.println("True!!"); // <---- disregard trueth statement if testing nonrectilinear polygons, needs return for convex function
		return new RectilinearPolygon(points);
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
	
	public Triangle[] getInnerTriangles() {
		Triangle[] triangles = new Triangle[points.size()];
		for(int i = 0; i < points.size(); i++) triangles[i] = (new Triangle(new ArrayList<Point>(List.of(points.get(i), points.get((i + 1)%points.size()), points.get((i + 2)%points.size())))));
		
		return triangles;
	}
	
	
	public boolean pythagoreanTheoremEquality(double side0, double side1, double side2) {
		return Math.round(Math.pow(side0, 2) + Math.pow(side1, 2)) == Math.round(Math.pow(side2, 2));
	}
}
