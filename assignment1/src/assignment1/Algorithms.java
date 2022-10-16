package assignment1;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

	private final ArrayList<Point> points;
	private final int numVertices;
	
	public Algorithms(List<Integer[]> coordinates) {
		points = convertToPoints(coordinates);
		this.numVertices = coordinates.size();
	}

	private ArrayList<Point> convertToPoints(List<Integer[]> coordinates){
		ArrayList<Point> points = new ArrayList<>();
		for(Integer[] o : coordinates) points.add(new Point(o[0], o[1]));
		return points;
	}

	/**
	 * Depending on the number of points in the class, will return a distinct geometric shape object
	 * @return geometric shape object
	 */
	public GeometricObject polygonType() {
		return switch (numVertices) {
			case 3 -> new Triangle(points);
			case 4 -> determineQuadrilateral();
			default -> determinePolygon();
		};
	}

	/**
	 * Determines n-sided polygon when n > 4.
	 * @return either a rectilinear, convex, or simple polygon
	 */
	private GeometricObject determinePolygon() {
		Triangle[] triangles = getInnerTriangles();

		for(Triangle t : triangles) //If point triplet does not form a right triangle, the polygon is convex or simple.
			if(pythagoreanTheoremEquality(t.getSideLength(0), t.getSideLength(1), t.getSideLength(2)))
				return determineIfConvex();

		return new RectilinearPolygon(points);
	}


	private double determinant(Point p0, Point p1, Point p2) {
		return (p0.getX()*p1.getY() + p1.getX()*p2.getY() + p2.getX()*p0.getY()) -
				(p1.getX()*p0.getY() + p2.getX()*p1.getY() + p0.getX()*p2.getY());
	}

	/**
	 * Given a sequence of points which define a polygon in counter-clockwise rotation, this function determines if a
	 * polygon is convex if every three consecutive points turn counter-clockwise.
	 * @return either a simple or convex polygon object
	 */
	private GeometricObject determineIfConvex() {
		for(int i = 0; i < points.size(); i++)
			if(determinant(
					points.get(i),
					points.get((i + 1) % points.size()),
					points.get((i + 2) % points.size())
				) < 0)
				return new SimplePolygon(points);

		return new ConvexPolygon(points);
	}

	/** Given a sequence of points which define a polygon in counter-clockwise rotation, this function determines if a
	 * polygon is a rectangle
	 * @return either a rectangle or quadrilateral object
	 */
	private GeometricObject determineQuadrilateral() {
		Triangle[] triangles = getInnerTriangles();

		for(Triangle t : triangles)
			if(pythagoreanTheoremEquality(t.getSideLength(0), t.getSideLength(1), t.getSideLength(2)) ||
					t.getSideLength(0) == t.getSideLength(1)) //Square case
				return new Quadrilateral(points);

		return new Rectangle(points.get(0), points.get(2));
	}


	/**
	 * Returns a triangle for every three consecutive points
	 * @return an array of triangle objects
	 */
	private Triangle[] getInnerTriangles() {
		Triangle[] triangles = new Triangle[points.size()];
		for(int i = 0; i < points.size(); i++)
			triangles[i] = (new Triangle(
					new ArrayList<>(List.of(
							points.get(i),
							points.get((i + 1) % points.size()), //Modulo avoids array out of bounds exception
							points.get((i + 2) % points.size())))
			));
		
		return triangles;
	}


	/**
	 * Tests if a right triangle does not exist
	 * @return True, if theorem does not hold
	 */
	private boolean pythagoreanTheoremEquality(double side0, double side1, double side2) {
		return Math.round(Math.pow(side0, 2) + Math.pow(side1, 2)) != Math.round(Math.pow(side2, 2));
	}
}
