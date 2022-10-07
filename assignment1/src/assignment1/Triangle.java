package assignment1;

import java.awt.Graphics;
import java.util.ArrayList;

public class Triangle extends GeometricObject{
	ArrayList<Point> points;
	double[] sideLengths; //each index corresponds to the beginning point so side(0) is side->p0p1, side(2) is side -> p2p0
	
	public Triangle(ArrayList<Point> points) {
		this.points = points;
		sideLengths = calculateSideLengths();
	}
	
	public double[] calculateSideLengths() {
		return new double[] {
				pointDistance(points.get(0), points.get(1)),
				pointDistance(points.get(1), points.get(2)),
				pointDistance(points.get(2), points.get(0))
		};
	}
	
	public double pointDistance(Point p0, Point p1) {
		return Math.sqrt(Math.pow(p1.getX() - p0.getX(), 2) + Math.pow(p1.getY() - p0.getY(), 2));
	}
	
	public Point getBegin() {
		return points.get(0);
	}
	
	public Point getMiddle() {
		return points.get(1);
	}
	
	public Point getEnd() {
		return points.get(2);
	}
	
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		//setting x and y value arrays for parameters in the method
		g.setColor(getInteriorColor());
		g.fillPolygon(
				new int[] {
						(int)points.get(0).getX(), 
						(int)points.get(1).getX(), 
						(int)points.get(2).getX()
				},
				new int[] {
						(int)points.get(1).getY(),
						(int)points.get(1).getY(),
						(int)points.get(2).getY()
				},
				points.size());
		
		g.setColor(getBoundaryColor());
		g.drawPolygon(
				new int[] {
						(int)points.get(0).getX(), 
						(int)points.get(1).getX(), 
						(int)points.get(2).getX(),
				},
				new int[] {
						(int)points.get(1).getY(),
						(int)points.get(1).getY(),
						(int)points.get(2).getY()
				},
				points.size());
	}
	
	public String toString() {
		String str = "Triangle " + super.toString() + "\n";
		str += getBegin() + "\n" + getMiddle() + "\n" + getEnd();
		return str;
	}
	

}
